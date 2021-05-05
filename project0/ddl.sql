-- public.bids definition

-- Drop table

-- DROP TABLE public.bids;

CREATE TABLE public.bids (
	bids_id serial NOT NULL,
	bid_amount numeric NOT NULL,
	bid_time_made timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	fk_customer_id int4 NULL,
	fk_item_id int4 NULL,
	bid_accepted bool NULL DEFAULT false,
	CONSTRAINT bids_pkey PRIMARY KEY (bids_id)
);


-- public.bids foreign keys

ALTER TABLE public.bids ADD CONSTRAINT fk_customer_id FOREIGN KEY (fk_customer_id) REFERENCES public.customer(customer_id);
ALTER TABLE public.bids ADD CONSTRAINT fk_item_id FOREIGN KEY (fk_item_id) REFERENCES public.items(item_id);

-- public.customer definition

-- Drop table

-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	customer_id serial NOT NULL,
	customer_username varchar(50) NOT NULL,
	customer_firstname varchar(50) NOT NULL,
	customer_lastname varchar(50) NOT NULL,
	customer_password varchar(50) NOT NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
);

-- public.employee definition

-- Drop table

-- DROP TABLE public.employee;

CREATE TABLE public.employee (
	employee_id serial NOT NULL,
	employee_username varchar(50) NOT NULL,
	employee_firstname varchar(50) NOT NULL,
	employee_password varchar(50) NOT NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (employee_id)
);

-- public.items definition

-- Drop table

-- DROP TABLE public.items;

CREATE TABLE public.items (
	item_id serial NOT NULL,
	item_name varchar(50) NOT NULL,
	item_price float8 NULL,
	"status_Owned" bool NOT NULL DEFAULT false,
	fk_customer_owner_id int4 NULL,
	CONSTRAINT items_pkey PRIMARY KEY (item_id)
);

ALTER TABLE public.items ALTER COLUMN "status_Owned" DROP NOT NULL;
ALTER TABLE public.items ALTER COLUMN "status_Owned" SET DEFAULT Null;



-- public.items foreign keys

ALTER TABLE public.items ADD CONSTRAINT fk_customer_owner_id FOREIGN KEY (fk_customer_owner_id) REFERENCES public.customer(customer_id);

-- public.manager definition

-- Drop table

-- DROP TABLE public.manager;

CREATE TABLE public.manager (
	manager_id serial NOT NULL,
	manager_username varchar(50) NOT NULL,
	manager_firstname varchar(50) NOT NULL,
	manager_password varchar(50) NOT NULL,
	CONSTRAINT manager_pkey PRIMARY KEY (manager_id)
);