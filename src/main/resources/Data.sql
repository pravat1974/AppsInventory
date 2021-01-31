

CREATE TABLE APPUser
(
     ID SERIAL PRIMARY KEY ,
    userName text  NOT NULL UNIQUE,
    password TEXT NOT NULL,
    mobile bigint NOT NULL UNIQUE,
    email text NOT NULL UNIQUE,
    createdBy text ,
    lastUpdatedBy text ,
    currentStatus text ,
    createdTime time without time zone NOT NULL,
    lastUpdatedTime time without time zone NOT NULL,
    userType text 
)


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
