drop table if exists character_species;
drop table if exists character_class;
drop table if exists deities;

CREATE TABLE character_species
(
    id BIGINT,
    description TEXT NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE character_class
(
    id BIGINT,
    description TEXT NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE deities
(
    id          BIGINT,
    description TEXT    null,
    name        VARCHAR(255) NOT NULL,
    proficiency TEXT  null
);

INSERT INTO character_class (id, name, description) VALUES (1, 'Bardo', 'Os Bardos são artistas e contadores de histórias habilidosos que usam sua música, poesia e charme para influenciar e inspirar aqueles ao seu redor. Eles são viajantes ávidos, buscando aventuras e experiências para enriquecer suas performances e expandir seu repertório. Os Bardos são mestres em se adaptar a diferentes situações e são valorizados por sua versatilidade e capacidade de entreter e motivar aliados.');
INSERT INTO character_class (id, name, description) VALUES (2, 'Guerreiro', 'Os Campeões Aldorianos são guerreiros resolutos, imbuídos de um profundo senso de dever para com a proteção de Aldoria. São mestres em combate corpo a corpo, hábeis no manuseio de várias armas e armaduras. Em sua busca por excelência marcial, esses guerreiros dedicam suas vidas ao treinamento rigoroso e à defesa incansável do reino.');
INSERT INTO character_class (id, name, description) VALUES (3, 'Ladino', 'O Ladino é um mestre das sombras e da astúcia, habilidoso em se mover silenciosamente, desarmar armadilhas e desvendar segredos. Eles são especialistas em furtividade, combate furtivo e no uso de venenos, tornando-se uma ameaça mortal para seus inimigos quando atacam das sombras.');
INSERT INTO character_class (id, name, description) VALUES (4, 'Mago', 'O Mago é um conjurador de magias poderosas, capaz de moldar a realidade à sua vontade por meio do estudo e da manipulação dos arcanos. Eles são mestres dos elementos e da magia arcana, usando seus conhecimentos para lançar feitiços devastadores e desafiar as leis da física.');

INSERT INTO character_species (id, name, description) VALUES (1, 'Anões', 'Os anões são seres humanoides de baixa estatura, geralmente medindo entre 1,20 e 1,50 metros de altura. Possuem corpos robustos e musculosos, com membros curtos e fortes.');
INSERT INTO character_species (id, name, description) VALUES (2, 'Elfos', 'Os elfos são seres de beleza etérea e graça natural, com características delicadas e formas esguias. Possuem uma estatura elegante, geralmente mais alta que a média humana, com membros longos e esbeltos.');
INSERT INTO character_species (id, name, description) VALUES (3, 'Humanos', 'Os humanos são uma raça versátil e diversificada, com uma ampla gama de características físicas. Em média, os humanos têm estatura moderada, variando de cerca de 1,60 a 1,90 metros de altura.');

INSERT INTO deities (id, description, name, proficiency) VALUES (1, 'Thalorin é o deus da ordem e da justiça. Ele é retratado como um ser imponente de barba longa, vestindo uma armadura brilhante e segurando uma espada flamejante que representa a lei. ', 'Thalorin, o Forjador Celestial', '**Julgamento:**  **Estratégia Militar:**  **Devoção:** ');
INSERT INTO deities (id, description, name, proficiency) VALUES (2, 'Lunara é uma deusa neutra que representa o equilíbrio e a harmonia na natureza. Ela é retratada como uma elfa celestial com cabelos prateados e olhos que brilham como as estrelas. ', 'Lunara, a Guardiã da Natureza', '**Herbalismo:** **Empatia Animal:** **Caça e Rastreamento:**');
INSERT INTO deities (id, description, name, proficiency) VALUES (3, 'Tharok é o deus da tempestade e do caos. Ele é representado como um gigante com pele azul e cabelos que se assemelham a relâmpagos. ', 'Tharok, o Senhor das Tempestades', 'Navegação: Pirataria: Desafio:');