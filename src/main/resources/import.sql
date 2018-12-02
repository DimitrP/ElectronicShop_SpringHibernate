-- insert cart data
INSERT INTO "cart" (sum) VALUES (0);
INSERT INTO "cart" (sum) VALUES (0);
INSERT INTO "cart" (sum) VALUES (0);
INSERT INTO "cart" (sum) VALUES (0);

-- insert user data
INSERT INTO "user" (login, password, active, cart_id, email) VALUES ('admin', '123456', true, 1, 'admin@gmail.com');
INSERT INTO "user" (login, password, active, cart_id, email) VALUES ('user', '123456', true, 2, 'user@gmail.com');
INSERT INTO "user" (login, password, active, cart_id, email) VALUES ('manager', '123456', true, 3, 'manager@gmail.com');
INSERT INTO "user" (login, password, active, cart_id, email) VALUES ('user2', '123456', false, 4, 'user2@gmail.com');

-- insert role data
INSERT INTO "role" (name) VALUES ('ROLE_ADMIN');
INSERT INTO "role" (name) VALUES ('ROLE_USER');
INSERT INTO "role" (name) VALUES ('ROLE_MANAGER');

-- insert user_role data
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 1);
INSERT INTO "user_role" (user_id, role_id) VALUES (2, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (3, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (3, 3);
INSERT INTO "user_role" (user_id, role_id) VALUES (4, 2);

--insert category data
INSERT INTO "category" (title, description) VALUES ('notebooks', 'Cards assume no specific width to start');
INSERT INTO "category" (title, description) VALUES ('tablets', 'Tablets to quickly set a card’s width.');
INSERT INTO "category" (title, description) VALUES ('mobile', 'Top mobile phones');
INSERT INTO "category" (title, description) VALUES ('photo cameras', 'mouse, keyboard, cards, etc.');

--insert good data
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook HP', '/resources/img/hp.jpeg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 20500, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook ASUS', '/resources/img/asus.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 108000, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook DELL', '/resources/img/dell.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 25000.50, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook PB', '/resources/img/pb.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 10233, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook Star Wars', '/resources/img/star_wars.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 40340, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook DEll INSPIRE 2', '/resources/img/dell_inspire_2.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 2500, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook PACKARD BELL 11LV', '/resources/img/packard_bell.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 12200, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook EASY NOTE2', '/resources/img/easy_note_2.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 7843, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook LENOVO', '/resources/img/lenovo.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 95000, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook GBDXX72 LA pgns', '/resources/img/GBDXX72.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 11000, 1);

INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet EASY LA pgns', '/resources/img/tablet_easy_la.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 12000, 2);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet LENOVO L BELL s', '/resources/img/tablet_lenovo_l_bell.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 15300, 2);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet NOTE2pg ns', '/resources/img/tablet_note2.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 22040, 2);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet GBD XX 72', '/resources/img/tablet_gbd.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 34200, 2);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id, active) VALUES ('Tablet LA AS NOOO70000', '/resources/img/tablet_la_as.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 23500, 2, false);

INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Apple IPhone 5s 16Gb', '/resources/img/5s.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 20900, 3);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Samsung Galaxy s6 32Gb', '/resources/img/samsung_galaxy_s6.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 19880, 3);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Xiaomi Redmi Note 4 64Gb', '/resources/img/xiaomi_redmi_note4.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 18990, 3);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Asus Zenfone 2 Laser 16Gb', '/resources/img/asus_zenfone2_laser.png', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 13490, 3);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Sony Xperia X 64Gb Black', '/resources/img/sony_xperia_x.png', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 32990, 3);

INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 100D 18-55DC Kit', '/resources/img/canon_eos_100d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 29990, 4);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 70D', '/resources/img/canon_eos_70d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 68990, 4);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 5D Mark 4 Body', '/resources/img/canon_eos_5d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 229990, 4);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 6D', '/resources/img/canon_eos_6d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 126990, 4);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('Nikon D5300', '/resources/img/nikon_d5300.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 39990, 4);



INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('MacBook Air 13', '/resources/img/apple_macbook_air_13.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 1399.99, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('2018 Newest Premium Flagship HP Pavilion 15.6"', '/resources/img/HP_Pavillion_15.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 388.00, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('2019 Premium Dell Inspiron 13 7000 13.3 Touchscreen', '/resources/img/Dell_Inspiron_13.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 579.00, 1);
INSERT INTO "product" (title, small_image_link, description, quantity, price, category_id) VALUES ('2019 Premium HP Spectre X360 13.3"IPS Touchscreen', '/resources/img/HP_Premium_Spectre_13.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 388.00, 1);







--insert news data
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('First news', 'We are opened', '/resources/img/dis1-1100x350.png', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Second news', 'We glad to see you on our site', '/resources/img/Mturk-Consulting-1100x350.png', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you on our site', '/resources/img/web_hosting-1100x350.jpg', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Other', 'We glad to see you on our site', '/resources/img/web_hosting-1100x350.jpg', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('New news', 'We glad to see you on our site', '/resources/img/web_hosting-1100x350.jpg', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Good Idea', 'We glad to see you on our site', '/resources/img/web_hosting-1100x350.jpg', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Intellij idea', 'We glad to see you on our site', '/resources/img/web_hosting-1100x350.jpg', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Next week in', 'We glad to see you on our site', '/resources/img/web_hosting-1100x350.jpg', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Hilton Garden Inn', 'We glad to see you on our site', '/resources/img/dis1-1100x350.png', '05/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Face 2', 'We glad to see you on our site', '/resources/img/web_hosting-1100x350.jpg', '05/27/2018' );


INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Industry news', 'We glad to see you on our site', '/resources/img/news_production_header.jpg', '11/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Digital laboratory', 'We glad to see you on our site', '/resources/img/digital-policy-lab-news.jpg', '11/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Laptop Android Phone', 'We glad to see you on our site', '/resources/img/Laptop-Android-Phone.jpeg', '11/27/2018' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('News and events', 'We glad to see you on our site', '/resources/img/news-and-events-hero.jpg', '11/27/2018' );