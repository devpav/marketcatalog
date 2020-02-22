insert into tbx_s_container(id, description, system_name)
VALUES
    ('a19e2196-9a8e-4a25-8e98-6d8eb578458f', 'Продукт', 'p'),
    ('a531733a-7f3c-4001-9afa-77c5fbdfa7cf', 'Характеристика', 'ch'),
    ('a2f67e2c-f430-42f1-84f0-c0bd459831ba', 'Системный', 's');

insert into tbx_s_entity_metadata(id, table_name, description, id_container)
VALUES
    ('3247f7e1-2adf-4c23-9c60-6952c5740793', 'cornice', 'Корниз', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f'),
    ('d4508d64-acf9-4aea-9edc-ddde1eaa6ba9', 'accessory', 'Аксессуар', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f'),
    ('30b9c908-cbde-4511-bc67-6f9886e90861', 'jalousie', 'Жалюзи', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f'),
    ('57ef02b6-eed2-489d-a41b-584a5bdc970a', 'rolstor', 'Рольштора', 'a19e2196-9a8e-4a25-8e98-6d8eb578458f'),

    ('ae842f08-27b8-4d4a-9027-25883f352f9e', 'data_type', 'Тип данных', 'a2f67e2c-f430-42f1-84f0-c0bd459831ba'),
    ('edcab99b-1fc6-4423-9f76-1218a98277b9', 'container', 'Контейнер', 'a2f67e2c-f430-42f1-84f0-c0bd459831ba'),
    ('283de48b-c432-4314-9274-7d0b978248f6', 'category', 'Категория', 'a2f67e2c-f430-42f1-84f0-c0bd459831ba'),
    ('35985b15-36a0-4324-8c92-dead84d1a6b3', 'entity_metadata', 'Метаданные сущности', 'a2f67e2c-f430-42f1-84f0-c0bd459831ba'),

    ('8e7afb48-ee0b-4df7-8b14-80e42cb4e081', 'characteristic', 'Характеристика продукта', 'a531733a-7f3c-4001-9afa-77c5fbdfa7cf'),
    ('c8d321e0-41fe-4cd2-a097-bc9a04582721', 'string_characteristic', 'Строковая характеристика', 'a531733a-7f3c-4001-9afa-77c5fbdfa7cf'),
    ('383314ff-6cc2-44e1-84a6-9bb3e5612a77', 'double_characteristic', 'Числовая характеристика', 'a531733a-7f3c-4001-9afa-77c5fbdfa7cf');

insert into tbx_s_data_type(id, name)
VALUES
    ('f8a17421-5b48-4d22-8899-25a8765bbecc', 'STRING'),
    ('bb2c2f80-6fed-4504-ae5a-e8604ae8591f', 'DOUBLE');

insert into tbx_s_category(id, title, id_parent_category, system_name, img)
VALUES
    ('5762a94b-43ce-4e0b-a635-c776e04b73ed','Карнизы', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'cornice', NULL),
    ('4afac74f-dfa0-4423-82b4-b0b50bb034c3','Металические', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'metallic', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/671/240_240_2/6717724f494cfc9f8c44133d6ec568ef.webp'),
    ('e5c91db9-7696-404c-a2a1-a9f6398f2793','Пластиковые потолочные', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'plastic_ceilings', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/e9b/240_240_2/e9b0f5a6e9363712ef4bbd742700e9b9.webp'),
    ('3a1142bf-9377-431f-bbc4-24b036afb2b2','Настенные металлопластиковые', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'wall_metal_plastic', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/2fb/240_240_2/2fb8cc7d97fc9ab7db56be63734e06ff.webp'),
    ('3f948223-2db4-4b7e-8a42-037c41494d86','Гибкие', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'flexible', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/625/240_240_2/62551e5ba338aef9c09cae05b7814fa2.webp'),
    ('282313fa-3d9b-4839-842a-7a56ef2bc222','Комплектующие для потолочных', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'accessories_for_ceiling', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/c7a/240_240_2/c7aa71890d5ede40b4d3e3d27685b653.webp'),
    ('ec5dc3c2-a6b7-46ee-8bee-8978e742d134','Металлопластиковая фурнитура', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'metal_plastic_accessories', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/69a/240_240_2/69ac0fa89964e2ef8d3070bbbad0b236.webp'),
    ('c4c33ec7-488d-4c26-970e-b8009b1b6c21','Комплектующие для металлических', '5762a94b-43ce-4e0b-a635-c776e04b73ed', 'accessories_for_metal', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/294/240_240_2/294039fd86e992eb1f45a47069f724ea.webp'),

    ('f9ba484d-b696-4a9a-ac79-f2fbd0cfa551','Рольшторы','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551', 'rolstor', NULL),
    ('b04302c0-2771-466e-baba-d2977e97ad2f','День/ночь','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551', 'day_night', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/4b7/240_240_2/4b7cf1c938dc255fe53eae7f79da528e.webp'),
    ('dc77d8d8-c96c-4889-bf8a-4e5930ed641a','Стандарт','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551', 'standard', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/9c2/240_240_2/9c2f656421966c065f1df6a7fcd06b7e.webp'),
    ('7a28617c-2a5f-4b3f-9e58-7dfa0b4d74bb','В коробке','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551', 'in_box', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/c7f/240_240_2/c7f4bc166f61976f8d9261a3db13cb00.webp'),
    ('6027dad3-9c43-4bf9-8520-5796d59a1300','Премиум','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551', 'premium', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/9aa/240_240_2/9aaebf094efdfd6eaca378acc3b90c26.webp'),
    ('bd93cb0e-50f1-4c7b-9a73-b515129d0e1b','Блэкаут','f9ba484d-b696-4a9a-ac79-f2fbd0cfa551', 'blackout', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/c6e/240_240_2/c6ed8f9f6cb4d7a4de6fea88750eb4a9.webp'),

    ('3ec43fef-647c-41f3-9fb5-2f930f60c089','Жалюзи','3ec43fef-647c-41f3-9fb5-2f930f60c089', 'jalousie', NULL),

    ('b569605e-a61f-4e66-b7b9-802edc7d8165','Акссуары','b569605e-a61f-4e66-b7b9-802edc7d8165', 'accessory', NULL),
    ('61984db7-c6e2-4935-af7b-b14d8a3a67e6','Люверсы','b569605e-a61f-4e66-b7b9-802edc7d8165', 'luversa', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/e0f/240_240_2/e0f14f5040cfbf48962735ee6e0ab881.webp'),
    ('b334c012-7e0f-47e8-8053-6d0e19adc9e6','Подхваты, держатели, крючки','b569605e-a61f-4e66-b7b9-802edc7d8165', 'grips_holders_hooks', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/e22/240_240_2/e228714f178ef1808cb807c581489262.webp'),
    ('e43e326a-14e3-45f2-849c-2fd371797d0f','Клипсы магнитные','b569605e-a61f-4e66-b7b9-802edc7d8165', 'magnetic_clips', 'https://asforos.by/upload/imedia.webp/webp/upload/resize_cache/iblock/f6b/240_240_2/f6b3a8449d65cae9d0ffb1ae57fb98aa.webp');
