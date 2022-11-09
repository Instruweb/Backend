INSERT INTO users (username, firstname, lastname, emailaddress, password, verified, role, address, postalcode, phonenumber)
VALUES ('Nickwelles', 'Nick', 'Welles', 'nick@welles.com', 'ditiseentest', true, 'admin', 'Jan met de korte achternaam straat', '5971PC', '0612345678');

INSERT INTO main_category (name) VALUES ("Gitaar");

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Gitaar', 3.5, 'gitaar.webp', 'mooi', 'Full', 1, 1);