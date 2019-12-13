insert into tbx_s_container(id, description, system_name)
VALUES
    ('a19e2196-9a8e-4a25-8e98-6d8eb578458f', 'Продукт', 'p'),
    ('a531733a-7f3c-4001-9afa-77c5fbdfa7cf', 'Характеристика', 'ch'),
    ('a2f67e2c-f430-42f1-84f0-c0bd459831ba', 'Системный', 's');

insert into tbx_s_entity_metadata(id, table_name, description, id_container)
VALUES
    ('3247f7e1-2adf-4c23-9c60-6952c5740793', 'cornice', 'Корниз', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f'),
    ('d4508d64-acf9-4aea-9edc-ddde1eaa6ba9', 'accessory', 'Аксессуар', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f'),
    ('30b9c908-cbde-4511-bc67-6f9886e90861', 'blind', 'Жалюзи', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f'),
    ('57ef02b6-eed2-489d-a41b-584a5bdc970a', 'curtain', 'Рольштора', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f');

insert into tbx_s_data_type(id, name)
VALUES
    ('f8a17421-5b48-4d22-8899-25a8765bbecc', 'STRING'),
    ('bb2c2f80-6fed-4504-ae5a-e8604ae8591f', 'DOUBLE');

insert into tbx_s_category(id, title, id_parent_category)
VALUES
    ('5762a94b-43ce-4e0b-a635-c776e04b73ed','Карнизы', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),
    ('4afac74f-dfa0-4423-82b4-b0b50bb034c3','Металические', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),
    ('e5c91db9-7696-404c-a2a1-a9f6398f2793','Пластиковые потолочные', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),
    ('3a1142bf-9377-431f-bbc4-24b036afb2b2','Настенные металлопластиковые', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),
    ('3f948223-2db4-4b7e-8a42-037c41494d86','Гибкие', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),
    ('282313fa-3d9b-4839-842a-7a56ef2bc222','Комплектующие для потолочных', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),
    ('ec5dc3c2-a6b7-46ee-8bee-8978e742d134','Металлопластиковая фурнитура', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),
    ('c4c33ec7-488d-4c26-970e-b8009b1b6c21','Комплектующие для металлических', '5762a94b-43ce-4e0b-a635-c776e04b73ed'),

    ('f9ba484d-b696-4a9a-ac79-f2fbd0cfa551','Рольшторы','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551'),
    ('b04302c0-2771-466e-baba-d2977e97ad2f','День/ночь','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551'),
    ('dc77d8d8-c96c-4889-bf8a-4e5930ed641a','Стандарт','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551'),
    ('7a28617c-2a5f-4b3f-9e58-7dfa0b4d74bb','В коробке','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551'),
    ('6027dad3-9c43-4bf9-8520-5796d59a1300','Премиум','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551'),
    ('bd93cb0e-50f1-4c7b-9a73-b515129d0e1b','Блэкаут','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551'),

    ('3ec43fef-647c-41f3-9fb5-2f930f60c089','Жалюзи','3ec43fef-647c-41f3-9fb5-2f930f60c089'),

    ('b569605e-a61f-4e66-b7b9-802edc7d8165','Акссуары','b569605e-a61f-4e66-b7b9-802edc7d8165'),
    ('61984db7-c6e2-4935-af7b-b14d8a3a67e6','Люверсы','b569605e-a61f-4e66-b7b9-802edc7d8165'),
    ('b334c012-7e0f-47e8-8053-6d0e19adc9e6','Подхваты, держатели, крючки','b569605e-a61f-4e66-b7b9-802edc7d8165'),
    ('e43e326a-14e3-45f2-849c-2fd371797d0f','Клипсы магнитные','b569605e-a61f-4e66-b7b9-802edc7d8165');
