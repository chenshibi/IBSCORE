--更新数据字典公共文件上传
UPDATE DATA_DIC SET DATA_TYPE_NO='706' WHERE ID=120413;
UPDATE DATA_DIC SET DATA_TYPE_NO='706' WHERE ID=120414;
UPDATE DATA_DIC SET DATA_TYPE_NO='707' WHERE ID=120415;
UPDATE DATA_DIC SET DATA_TYPE_NO='707' WHERE ID=120415;
--
ALTER TABLE IBS_QUERY_EXPIRE modify (UPDATE_TIME TIMESTAMP(6));

ALTER TABLE IBS_QUERY_EXPIRE MODIFY (EXPIRE_TIME TIMESTAMP(6));

--企业借贷业务种类新增18-创业担保贷款
INSERT INTO DATA_DIC (ID, DATA_TYPE_NO, DATA_NO, DATA_TYPE_NAME, DATA_NO_LEN, DATA_NAME, LIMIT_FLAG, HIGH_LIMIT, LOW_LIMIT, EFFECT_DATE, EXPIRE_DATE, TIMESTAMPS, MISCFLGS, APPROVE_STATUS, APPROVE_RESULT, REC_STATUS, REP_STATUS, IS_SUB_SUCCESS, CRT_TM, LST_UPD_TM, LST_UPD_TLR, APPTYPE, BR_NO, YWDATE, ORGCODE, RECORD_UPD_TLR, RECORD_UPD_TM, ST) VALUES (120533.00, 6085.00, '18', '企业借贷业务种类细分（贷款）', 6.00, '18-创业担保贷款', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
--个人借贷业务种类新增42-个人创业担保贷款
INSERT INTO DATA_DIC (ID, DATA_TYPE_NO, DATA_NO, DATA_TYPE_NAME, DATA_NO_LEN, DATA_NAME, LIMIT_FLAG, HIGH_LIMIT, LOW_LIMIT, EFFECT_DATE, EXPIRE_DATE, TIMESTAMPS, MISCFLGS, APPROVE_STATUS, APPROVE_RESULT, REC_STATUS, REP_STATUS, IS_SUB_SUCCESS, CRT_TM, LST_UPD_TM, LST_UPD_TLR, APPTYPE, BR_NO, YWDATE, ORGCODE, RECORD_UPD_TLR, RECORD_UPD_TM, ST) VALUES (120534.00, 6020.00, '42', '个人借贷交易业务种类', 6.00, '42-个人创业担保贷款', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
--后付费业务类型新增2-自来水业务
INSERT INTO DATA_DIC (ID, DATA_TYPE_NO, DATA_NO, DATA_TYPE_NAME, DATA_NO_LEN, DATA_NAME, LIMIT_FLAG, HIGH_LIMIT, LOW_LIMIT, EFFECT_DATE, EXPIRE_DATE, TIMESTAMPS, MISCFLGS, APPROVE_STATUS, APPROVE_RESULT, REC_STATUS, REP_STATUS, IS_SUB_SUCCESS, CRT_TM, LST_UPD_TM, LST_UPD_TLR, APPTYPE, BR_NO, YWDATE, ORGCODE, RECORD_UPD_TLR, RECORD_UPD_TM, ST) VALUES (120535.00, 6016.00, '2', '后付费业务类型', 6.00, '2-自来水业务', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
--机构类型新增54-保理公司
INSERT INTO DATA_DIC (ID, DATA_TYPE_NO, DATA_NO, DATA_TYPE_NAME, DATA_NO_LEN, DATA_NAME, LIMIT_FLAG, HIGH_LIMIT, LOW_LIMIT, EFFECT_DATE, EXPIRE_DATE, TIMESTAMPS, MISCFLGS, APPROVE_STATUS, APPROVE_RESULT, REC_STATUS, REP_STATUS, IS_SUB_SUCCESS, CRT_TM, LST_UPD_TM, LST_UPD_TLR, APPTYPE, BR_NO, YWDATE, ORGCODE, RECORD_UPD_TLR, RECORD_UPD_TM, ST) VALUES (120536.00, 6018.00, '54', '机构类型', 6.00, '54-保理公司', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
--五级分类新增6-违约
INSERT INTO DATA_DIC (ID, DATA_TYPE_NO, DATA_NO, DATA_TYPE_NAME, DATA_NO_LEN, DATA_NAME, LIMIT_FLAG, HIGH_LIMIT, LOW_LIMIT, EFFECT_DATE, EXPIRE_DATE, TIMESTAMPS, MISCFLGS, APPROVE_STATUS, APPROVE_RESULT, REC_STATUS, REP_STATUS, IS_SUB_SUCCESS, CRT_TM, LST_UPD_TM, LST_UPD_TLR, APPTYPE, BR_NO, YWDATE, ORGCODE, RECORD_UPD_TLR, RECORD_UPD_TM, ST) VALUES (120537.00, 6032.00, '6', '五级分类', 6.00, '6-违约', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
--后付费账户类型新增UE-公用事业缴费账户
INSERT INTO DATA_DIC (ID, DATA_TYPE_NO, DATA_NO, DATA_TYPE_NAME, DATA_NO_LEN, DATA_NAME, LIMIT_FLAG, HIGH_LIMIT, LOW_LIMIT, EFFECT_DATE, EXPIRE_DATE, TIMESTAMPS, MISCFLGS, APPROVE_STATUS, APPROVE_RESULT, REC_STATUS, REP_STATUS, IS_SUB_SUCCESS, CRT_TM, LST_UPD_TM, LST_UPD_TLR, APPTYPE, BR_NO, YWDATE, ORGCODE, RECORD_UPD_TLR, RECORD_UPD_TM, ST) VALUES (120538.00, 6045.00, 'UE', '后付费账户类型', 6.00, 'UE-公用事业缴费账户', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
--将原"电信缴费账户当前缴费状态"名称调整为"后付费业务当前缴费状态"
UPDATE DATA_DIC SET DATA_TYPE_NAME ='后付费业务当前缴费状态' WHERE DATA_TYPE_NO ='6106';
