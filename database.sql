DROP TABLE IF EXISTS `azienda`;

CREATE TABLE `azienda` (
    `id_azienda` bigint(20) NOT NULL AUTO_INCREMENT,
    `localita` varchar(255) DEFAULT NULL,
    `nome` varchar(255) DEFAULT NULL,
    `partita_iva` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_azienda`)
);

---

DROP TABLE IF EXISTS `candidatura`;

CREATE TABLE `candidatura` (
    `id_candidatura` bigint(20) NOT NULL AUTO_INCREMENT,
    `id_tirocinio` bigint(20) NOT NULL,
    `id_utente` bigint(20) NOT NULL,
    `orario_lavoro` varchar(255) DEFAULT NULL,
    `stato` int(11) NOT NULL,
    PRIMARY KEY (`id_candidatura`)
);

---

DROP TABLE IF EXISTS `competenza`;

CREATE TABLE `competenza` (
    `id_competenza` bigint(20) NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_competenza`)
);

---

DROP TABLE IF EXISTS `tirocinio`;

CREATE TABLE `tirocinio` (
    `id_tirocinio` bigint(20) NOT NULL AUTO_INCREMENT,
    `descrizione` varchar(255) DEFAULT NULL,
    `durata` varchar(255) DEFAULT NULL,
    `id_azienda` bigint(20) NOT NULL,
    `mansione` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_tirocinio`)
);

---

DROP TABLE IF EXISTS `utente`;

CREATE TABLE `utente` (
    `id_utente` bigint(20) NOT NULL AUTO_INCREMENT,
    `cv` varbinary(255) DEFAULT NULL,
    `cognome` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `nome` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_utente`)
);

-- Dati per la tabella 'azienda'
INSERT INTO
    `azienda` (
        `localita`,
        `nome`,
        `partita_iva`
    )
VALUES (
        'Milano',
        'Tech Solutions S.p.A.',
        '01234567890'
    ),
    (
        'Roma',
        'Green Energy SRL',
        '10987654321'
    ),
    (
        'Torino',
        'Digital Marketing Hub',
        '23456789012'
    ),
    (
        'Napoli',
        'Logistica Veloce',
        '34567890123'
    ),
    (
        'Bologna',
        'Finanza Innovativa',
        '45678901234'
    );

-- Dati per la tabella 'utente' (candidati)
-- Le password sono fittizie (es. 'password123') e non criptate per semplicità
INSERT INTO
    `utente` (
        `cognome`,
        `email`,
        `nome`,
        `password`
    )
VALUES (
        'Rossi',
        'mario.rossi@email.com',
        'Mario',
        'passmario'
    ),
    (
        'Bianchi',
        'laura.bianchi@email.com',
        'Laura',
        'passlaura'
    ),
    (
        'Verdi',
        'carlo.verdi@email.com',
        'Carlo',
        'passcarlo'
    ),
    (
        'Neri',
        'giulia.neri@email.com',
        'Giulia',
        'passgiulia'
    ),
    (
        'Gialli',
        'alessio.gialli@email.com',
        'Alessio',
        'passalessio'
    );

-- Dati per la tabella 'competenza'
INSERT INTO
    `competenza` (`nome`)
VALUES ('Python'),
    ('Java'),
    ('Analisi Dati'),
    ('SEO/SEM'),
    ('Gestione Progetti'),
    ('Contabilità'),
    ('Logistica'),
    ('Cloud Computing');

-- Dati per la tabella 'tirocinio'
INSERT INTO
    `tirocinio` (
        `descrizione`,
        `durata`,
        `id_azienda`,
        `mansione`
    )
VALUES (
        'Supporto allo sviluppo di nuove applicazioni backend.',
        '6 mesi',
        1,
        'Sviluppatore Junior Python'
    ),
    (
        'Analisi dei dati di mercato e reportistica trimestrale.',
        '4 mesi',
        5,
        'Analista Finanziario'
    ),
    (
        'Ottimizzazione delle campagne pubblicitarie online.',
        '3 mesi',
        3,
        'Specialista Marketing Digitale'
    ),
    (
        'Gestione della flotta e pianificazione delle rotte.',
        '6 mesi',
        4,
        'Assistente Logistica'
    ),
    (
        'Manutenzione e implementazione di sistemi in Java.',
        '5 mesi',
        1,
        'Programmatore Java Backend'
    ),
    (
        'Assistenza alla redazione di bilanci e documenti fiscali.',
        '6 mesi',
        5,
        'Tirocinante Contabilità'
    ),
    (
        'Ricerca e sviluppo di soluzioni per l\'energia solare.',
        '6 mesi',
        2,
        'Ingegnere Energia Rinnovabile'
    );

-- Dati per la tabella 'candidatura'
INSERT INTO
    `candidatura` (
        `id_tirocinio`,
        `id_utente`,
        `orario_lavoro`,
        `stato`
    )
VALUES
    -- Mario Rossi (id_utente: 1)
    (1, 1, 'Full-time', 3), -- Accettato per Sviluppatore Python
    (7, 1, 'Full-time', 4), -- Rifiutato per Ingegnere Energia
    -- Laura Bianchi (id_utente: 2)
    (3, 2, 'Part-time', 2), -- In Valutazione per Marketing Digitale
    (5, 2, 'Full-time', 1), -- Inviata per Programmatore Java
    -- Carlo Verdi (id_utente: 3)
    (4, 3, 'Full-time', 3), -- Accettato per Assistente Logistica
    (6, 3, 'Full-time', 4), -- Rifiutato per Contabilità
    -- Giulia Neri (id_utente: 4)
    (2, 4, 'Part-time', 1), -- Inviata per Analista Finanziario
    -- Alessio Gialli (id_utente: 5)
    (5, 5, 'Full-time', 1);
-- Inviata per Programmatore Java