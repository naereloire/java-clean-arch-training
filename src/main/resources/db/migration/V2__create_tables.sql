create TABLE IF NOT EXISTS recommendation.categories (
    id SERIAL,
    category_name TEXT NOT NULL,
    PRIMARY KEY (id)
);

create TABLE IF NOT EXISTS recommendation.subcategories (
    id SERIAL,
    subcategory_name TEXT NOT NULL,
    category_id  INT8 NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY( category_id) REFERENCES recommendation.categories(id)
);


create TABLE IF NOT EXISTS recommendation.products (
    id SERIAL,
    product_name TEXT NOT NULL,
    subcategory_id  INT8 NOT NULL,
    price NUMERIC NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(subcategory_id) REFERENCES recommendation.subcategories(id)
);
