

-- Table: public.category

-- DROP TABLE public.category;

CREATE TABLE public.category
(
    id integer NOT NULL DEFAULT nextval('category_id_seq'::regclass),
    categoryname text COLLATE pg_catalog."default" NOT NULL,
    displayname text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    creationdate timestamp without time zone NOT NULL,
    startdate timestamp without time zone NOT NULL,
    enddate timestamp without time zone NOT NULL,
    categorytype text COLLATE pg_catalog."default",
    CONSTRAINT category_pkey PRIMARY KEY (id),
    CONSTRAINT category_categoryname_key UNIQUE (categoryname)
)

TABLESPACE pg_default;

ALTER TABLE public.category
    OWNER to postgres;


    CREATE TABLE Inventory
(
    
 id SERIAL PRIMARY KEY,
	
	inventoryName TEXT ,
	
creationDate time without time zone NOT NULL,
	
	 startDate time without time zone NOT NULL,
	
	 endDate   time without time zone NOT NULL,
	
 displayName TEXT ,
	
	 description TEXT  ,
	
	 catagoryId bigint,
	
 availStatus TEXT ,
	
 availabilityDate   time without time zone NOT NULL,
	
	 stockLevel bigint,
	

	
  stockThresh bigint,
	
	 itemPriceId bigint
	
	
)
