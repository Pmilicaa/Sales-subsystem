INSERT INTO `businessinfodb`.`company` (`id`, `mib`, `pib`, `active`, `address`, `contact`) VALUES ('1', '1234', '1234', True, 'Bulevar Oslobodjenja', '066223885');
INSERT INTO `businessinfodb`.`business_partner` (`id`, `mib`, `pib`, `active`, `address`, `contact`, `e_mail`, `name_partner`, `company_id`) VALUES (1, 1, 1, True, 'balzakova', 06543568, 'nesto@gmail.com', 'firma', 1)
INSERT INTO `businessinfodb`.`article_group` (`id`, `name`, `company_article_group`) VALUES (1, 'electrics', 1)
INSERT INTO `businessinfodb`.`unit_of_measure` (`id`, `name`, `short_name`) VALUES ('1', 'centimeter', 'cm');
INSERT INTO `businessinfodb`.`unit_of_measure` (`id`, `name`, `short_name`) VALUES ('2', 'decimeter', 'dm');
INSERT INTO `businessinfodb`.`unit_of_measure` (`id`, `name`, `short_name`) VALUES ('3', 'meter', 'm');
insert into price_list_item(id, price) values(1, 200.0)
INSERT INTO `businessinfodb`.`article` (`id`, `active`, `description`, `name`, `article_group_article`, `company_article`,price_list_item, `unit_of_measure_article`) VALUES (1, True, 'novi', 'novi', 1, 1,1, 1)
INSERT INTO `businessinfodb`.`business_year` (`id`, `active`, `locked`, `year`, `company_id`) VALUES (1, True, True, 2021, 1)
INSERT INTO `businessinfodb`.`output_invoice` (`id`, `active`, `number_account`, `release_date`, `status`, `total_base`, `totalpdv`, `total_payment`, `value_date`, `business_partner_id`, `business_year_id`, `company_id`) VALUES (1, True, 1, '2021-12-12', 1, 1, 1, 1, '2021-12-12', 1, 1, 1)
INSERT INTO `businessinfodb`.`invoice_item` (`id`, `active`, `amount`, `amountpdv`, `base`, `discount`, `percentagepdv`, `serial_numb_acc_item`, `total`, `unit_price`, `article_id`, `output_invoice_id`) VALUES (1, True, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
insert into price_list(id, valid_from, price_per_unit, company_price) values(1, '1645322992523', 25.5, 1)
