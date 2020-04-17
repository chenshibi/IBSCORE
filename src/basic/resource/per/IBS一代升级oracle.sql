--修改_表结构_字段属性 (by quxin 2020.01.07)    企业查询征信申请（单笔），非必填项，Oracle插入表报错：不能插入null(原sqlserver插入无值转为空字符串，oracle插入‘’空字符串也为null),故改表结构字段属性。
alter table T_CORP_PERMIT MODIFY LOAN_CARD_PASS null;
alter table T_CORP_PERMIT MODIFY ENTERPRISE_REG_ID null;
alter table T_CORP_APP MODIFY LOAN_CARD_PASS null;

--修改_表结构_字段长度 (by quxin 2020.02.02) 展示长度不够，因为当身份为企业是逾期月数可能超过10
 alter table  CR_PER_PCR MODIFY (PD03AD07 VARCHAR2(2));
 
--修改_字典_名称 (by quxin 2020.02.24 from chensibi 2020.02.07)
update data_dic set data_name='93-缺少近两年信贷信息' where id='6085';

--修改_字典(by quxin 2020.02.24 from chensibi 2020.02.13) 原数据有空格，需要去掉
update data_dic set data_name='H-住宿和餐饮业' where id='6472'; 
