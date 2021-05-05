create TABLE IF NOT EXISTS recommendation.subcategory (
    id SERIAL,
    subcategory_name TEXT NOT NULL,
    category_id  INT8 NOT NULL,
    category_name TEXT NOT NULL,
    PRIMARY KEY (id)
);


create TABLE IF NOT EXISTS recommendation.products (
    id SERIAL,
    product_name TEXT NOT NULL,
    subcategory_id  INT8 NOT NULL,
    price NUMERIC NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(subcategory_id) REFERENCES recommendation.subcategory(id)
);
