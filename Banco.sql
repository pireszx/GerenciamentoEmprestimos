CREATE DATABASE GerenciamentoEmprestimos;
USE GerenciamentoEmprestimos;

-- Tabela de Itens
CREATE TABLE Itens (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

-- Tabela de Usuários
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    contato VARCHAR(50)
);

-- Tabela de Empréstimos
CREATE TABLE Emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_item INT,
    id_usuario INT,
    data_emprestimo DATETIME,
    data_vencimento DATETIME,
	estado ENUM('devolvido', 'emprestado') NOT NULL DEFAULT 'devolvido',
    FOREIGN KEY (id_item) REFERENCES Itens(id),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);

-- Tabela de Histórico
CREATE TABLE Historico (
    id_historico INT AUTO_INCREMENT PRIMARY KEY,
    id_emprestimo INT,
    estado ENUM('empréstimo', 'devolução') NOT NULL,
    data_acao DATETIME NOT NULL,
    FOREIGN KEY (id_emprestimo) REFERENCES Emprestimos(id)
);

-- Inserir dados na tabela Itens
INSERT INTO Itens (nome, categoria) VALUES 
('Livro A', 'Livros'),
('Livro B', 'Livros'),
('Câmera X', 'Eletrônicos'),
('Notebook Y', 'Eletrônicos');

-- Inserir dados na tabela Usuarios
INSERT INTO Usuarios (nome, matricula, contato) VALUES
('Ana Silva', 'MAT001', 'ana.silva@email.com'),
('João Oliveira', 'MAT002', 'joao.oliveira@email.com'),
('Maria Souza', 'MAT003', 'maria.souza@email.com'),
('Carlos Lima', 'MAT004', 'carlos.lima@email.com');

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Trigger para atualizar o estado do item após um empréstimo
DELIMITER //
CREATE TRIGGER TriggerAdicionaData
BEFORE INSERT ON Emprestimos
FOR EACH ROW
BEGIN
    -- Define a data atual como data_emprestimoTriggerAdicionaData
    SET NEW.data_emprestimo = NOW();

    -- Define a data de vencimento como 7 dias após a data_emprestimo
    SET NEW.data_vencimento = NOW() + INTERVAL 1 MINUTE;
END;//

CREATE TRIGGER TriggerAdicionaHistoricoEmprestimo
AFTER INSERT ON Emprestimos
FOR EACH ROW
BEGIN
    -- Insere o registro no histórico
    INSERT INTO Historico (id_emprestimo, estado, data_acao)
    VALUES (
        NEW.id,          -- ID do empréstimo recém-inserido
        'empréstimo',    -- Estado do histórico
        NOW()            -- Data e hora atual
    );
    
END; //

CREATE TRIGGER TriggerAdicionaHistoricoDevolucao
AFTER UPDATE ON Emprestimos
FOR EACH ROW
BEGIN
    -- Insere o registro no histórico
    INSERT INTO Historico (id_emprestimo, estado, data_acao)
    VALUES (
        NEW.id,          -- ID do empréstimo recém-inserido
        'Devolução',    -- Estado do histórico
        NOW()            -- Data e hora atual
    );
    
END;

DELIMITER;
select* from usuarios;
select* from emprestimos;
select* from historico;
insert into emprestimos (id_item, id_usuario, estado) values (1, 1, 'emprestado');
update emprestimos
set estado = 'devolvido'
where id_item = 1;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- View para consultar o histórico de empréstimos
CREATE VIEW vw_historico_emprestimos AS
SELECT 
    h.id_historico AS 'Histórico',
    e.id AS 'Emprestimos',
    u.nome AS 'Responsável',
    i.nome AS 'Item',
    h.estado AS 'Status',
    h.data_acao AS 'Atualização',
    u.matricula AS 'Matricula'  -- Adicionando a matrícula na view
FROM 
    Historico h
JOIN 
    Emprestimos e ON h.id_emprestimo = e.id
JOIN 
    Usuarios u ON e.id_usuario = u.id
JOIN 
    Itens i ON e.id_item = i.id;

    
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Procedure para relatório de itens mais emprestados
DELIMITER //

CREATE PROCEDURE RelatorioItensMaisEmprestados()
BEGIN
    SELECT 
        i.nome AS Item,
        COUNT(e.id) AS QuantidadeEmprestimos
    FROM 
        Emprestimos e
    JOIN 
        Itens i ON e.id_item = i.id
    GROUP BY 
        i.id
    ORDER BY 
        QuantidadeEmprestimos DESC;
END //

DELIMITER ;


-- Procedure para relatório de itens com devoluções atrasadas
DELIMITER //
CREATE PROCEDURE RelatorioItensAtrasados()
BEGIN
    SELECT 
        u.nome AS Responsavel,
        i.nome AS Item,
        e.data_emprestimo AS Emprestimo,
        e.data_vencimento AS Vencimento,
        TIMESTAMPDIFF(MINUTE, e.data_vencimento, NOW()) AS DiasAtraso 
    FROM 
        Emprestimos e
    JOIN 
        Itens i ON e.id_item = i.id
    JOIN 
        Usuarios u ON e.id_usuario = u.id
    WHERE 
        e.data_vencimento < NOW() 
        AND e.estado = 'emprestado'
    ORDER BY 
        DiasAtraso DESC;
END;

DELIMITER;

DROP PROCEDURE IF EXISTS RelatorioItensAtrasados;

CALL RelatorioItensAtrasados();

DROP TRIGGER TriggerAdicionaData;


SELECT * FROM Itens;
SELECT * FROM vw_historico_emprestimos