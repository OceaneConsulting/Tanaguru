SET foreign_key_checks=0;

INSERT IGNORE INTO `PARAMETER_ELEMENT` (`Id_Parameter_Element`, `Cd_Parameter_Element`, `Id_Parameter_Family`, `Long_Label`, `Short_Label`) VALUES
(42, 'INCLUSION_REGEXP', 1, 'Regulard expression to crawl on a specific folder', 'inclusion regex');

INSERT IGNORE INTO `PARAMETER` (`Id_Parameter_Element`, `Parameter_Value`, `Is_Default`) VALUES
(42, '', b'1');

ALTER IGNORE TABLE REFERENCE ADD `Id_Default_Level` bigint(20) DEFAULT 2 AFTER `Url`;

ALTER TABLE `REFERENCE`
	ADD CONSTRAINT `fk_Ref_Level` FOREIGN KEY Id_Default_Level_Index (`Id_Default_Level`)  REFERENCES `LEVEL` (`Id_Level`) ON DELETE NO ACTION;

ALTER TABLE `PARAMETER`	ADD UNIQUE KEY `Unique_Param_Element_Type_Param_value` 
        (`Parameter_Value`(255),`Id_Parameter_Element`);

ALTER TABLE `THEME` ADD UNIQUE INDEX `Cd_Theme_UNIQUE` (`Cd_Theme` ASC);
ALTER TABLE `TEST` ADD UNIQUE INDEX `Cd_Test_UNIQUE` (`Cd_Test` ASC);
ALTER TABLE `CRITERION` ADD UNIQUE INDEX `Cd_Criterion_UNIQUE` (`Cd_Criterion` ASC);
ALTER TABLE `REFERENCE` ADD UNIQUE INDEX `Cd_Reference_UNIQUE` (`Cd_Reference` ASC);

SET foreign_key_checks=1;