package org.sky.land.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class LandParttimeJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public LandParttimeJobExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    public List<Criteria> integratedQuery(Map queryCondationMap) {
            Criteria criteria = createCriteriaInternal();
    for(Object key : queryCondationMap.keySet()) {
		String field = ((String)key).split("@")[0];
		String opt = ((String)key).split("@")[1];
		if(((String)key).toUpperCase().contains("BETWEEN")){
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,((String)queryCondationMap.get(key)).split(",")[0],((String)queryCondationMap.get(key)).split(",")[1],(String)key);
		}else if(((String)key).toUpperCase().contains("IS NULL")||((String)key).toUpperCase().contains("IS NOT NULL")){
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt);
		}else if(((String)key).toUpperCase().contains("@IN")||((String)key).toUpperCase().contains("@NOT IN")){
         String values = (String)queryCondationMap.get(key);
 		  List val=Arrays.asList(values.split(","));
 		  criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,val,(String)key);
		}else{
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,queryCondationMap.get(key),(String)key);
		}
    }
	 oredCriteria.add(criteria);
    return oredCriteria;

    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPremisesIsNull() {
            addCriterion("PREMISES is null");
            return (Criteria) this;
        }

        public Criteria andPremisesIsNotNull() {
            addCriterion("PREMISES is not null");
            return (Criteria) this;
        }

        public Criteria andPremisesEqualTo(String value) {
            addCriterion("PREMISES =", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotEqualTo(String value) {
            addCriterion("PREMISES <>", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesGreaterThan(String value) {
            addCriterion("PREMISES >", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesGreaterThanOrEqualTo(String value) {
            addCriterion("PREMISES >=", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesLessThan(String value) {
            addCriterion("PREMISES <", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesLessThanOrEqualTo(String value) {
            addCriterion("PREMISES <=", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesLike(String value) {
            addCriterion("PREMISES like", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotLike(String value) {
            addCriterion("PREMISES not like", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesIn(List<String> values) {
            addCriterion("PREMISES in", values, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotIn(List<String> values) {
            addCriterion("PREMISES not in", values, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesBetween(String value1, String value2) {
            addCriterion("PREMISES between", value1, value2, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotBetween(String value1, String value2) {
            addCriterion("PREMISES not between", value1, value2, "premises");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("SALARY is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("SALARY is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("SALARY =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("SALARY <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("SALARY >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("SALARY >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("SALARY <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("SALARY <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("SALARY like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("SALARY not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("SALARY in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("SALARY not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("SALARY between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("SALARY not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andWorkTimesIsNull() {
            addCriterion("WORK_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimesIsNotNull() {
            addCriterion("WORK_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimesEqualTo(String value) {
            addCriterion("WORK_TIMES =", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesNotEqualTo(String value) {
            addCriterion("WORK_TIMES <>", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesGreaterThan(String value) {
            addCriterion("WORK_TIMES >", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TIMES >=", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesLessThan(String value) {
            addCriterion("WORK_TIMES <", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesLessThanOrEqualTo(String value) {
            addCriterion("WORK_TIMES <=", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesLike(String value) {
            addCriterion("WORK_TIMES like", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesNotLike(String value) {
            addCriterion("WORK_TIMES not like", value, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesIn(List<String> values) {
            addCriterion("WORK_TIMES in", values, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesNotIn(List<String> values) {
            addCriterion("WORK_TIMES not in", values, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesBetween(String value1, String value2) {
            addCriterion("WORK_TIMES between", value1, value2, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkTimesNotBetween(String value1, String value2) {
            addCriterion("WORK_TIMES not between", value1, value2, "workTimes");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("WORK_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("WORK_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("WORK_PLACE =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("WORK_PLACE <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("WORK_PLACE >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_PLACE >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("WORK_PLACE <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("WORK_PLACE <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("WORK_PLACE like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("WORK_PLACE not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("WORK_PLACE in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("WORK_PLACE not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("WORK_PLACE between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("WORK_PLACE not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andReqNumIsNull() {
            addCriterion("REQ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andReqNumIsNotNull() {
            addCriterion("REQ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andReqNumEqualTo(String value) {
            addCriterion("REQ_NUM =", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotEqualTo(String value) {
            addCriterion("REQ_NUM <>", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumGreaterThan(String value) {
            addCriterion("REQ_NUM >", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_NUM >=", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLessThan(String value) {
            addCriterion("REQ_NUM <", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLessThanOrEqualTo(String value) {
            addCriterion("REQ_NUM <=", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLike(String value) {
            addCriterion("REQ_NUM like", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotLike(String value) {
            addCriterion("REQ_NUM not like", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumIn(List<String> values) {
            addCriterion("REQ_NUM in", values, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotIn(List<String> values) {
            addCriterion("REQ_NUM not in", values, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumBetween(String value1, String value2) {
            addCriterion("REQ_NUM between", value1, value2, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotBetween(String value1, String value2) {
            addCriterion("REQ_NUM not between", value1, value2, "reqNum");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNull() {
            addCriterion("SETTLEMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNotNull() {
            addCriterion("SETTLEMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeEqualTo(String value) {
            addCriterion("SETTLEMENT_TYPE =", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotEqualTo(String value) {
            addCriterion("SETTLEMENT_TYPE <>", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThan(String value) {
            addCriterion("SETTLEMENT_TYPE >", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLEMENT_TYPE >=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThan(String value) {
            addCriterion("SETTLEMENT_TYPE <", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThanOrEqualTo(String value) {
            addCriterion("SETTLEMENT_TYPE <=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLike(String value) {
            addCriterion("SETTLEMENT_TYPE like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotLike(String value) {
            addCriterion("SETTLEMENT_TYPE not like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIn(List<String> values) {
            addCriterion("SETTLEMENT_TYPE in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotIn(List<String> values) {
            addCriterion("SETTLEMENT_TYPE not in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeBetween(String value1, String value2) {
            addCriterion("SETTLEMENT_TYPE between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotBetween(String value1, String value2) {
            addCriterion("SETTLEMENT_TYPE not between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andPostMsgIsNull() {
            addCriterion("POST_MSG is null");
            return (Criteria) this;
        }

        public Criteria andPostMsgIsNotNull() {
            addCriterion("POST_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andPostMsgEqualTo(String value) {
            addCriterion("POST_MSG =", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgNotEqualTo(String value) {
            addCriterion("POST_MSG <>", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgGreaterThan(String value) {
            addCriterion("POST_MSG >", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgGreaterThanOrEqualTo(String value) {
            addCriterion("POST_MSG >=", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgLessThan(String value) {
            addCriterion("POST_MSG <", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgLessThanOrEqualTo(String value) {
            addCriterion("POST_MSG <=", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgLike(String value) {
            addCriterion("POST_MSG like", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgNotLike(String value) {
            addCriterion("POST_MSG not like", value, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgIn(List<String> values) {
            addCriterion("POST_MSG in", values, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgNotIn(List<String> values) {
            addCriterion("POST_MSG not in", values, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgBetween(String value1, String value2) {
            addCriterion("POST_MSG between", value1, value2, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostMsgNotBetween(String value1, String value2) {
            addCriterion("POST_MSG not between", value1, value2, "postMsg");
            return (Criteria) this;
        }

        public Criteria andPostReqIsNull() {
            addCriterion("POST_REQ is null");
            return (Criteria) this;
        }

        public Criteria andPostReqIsNotNull() {
            addCriterion("POST_REQ is not null");
            return (Criteria) this;
        }

        public Criteria andPostReqEqualTo(String value) {
            addCriterion("POST_REQ =", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqNotEqualTo(String value) {
            addCriterion("POST_REQ <>", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqGreaterThan(String value) {
            addCriterion("POST_REQ >", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqGreaterThanOrEqualTo(String value) {
            addCriterion("POST_REQ >=", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqLessThan(String value) {
            addCriterion("POST_REQ <", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqLessThanOrEqualTo(String value) {
            addCriterion("POST_REQ <=", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqLike(String value) {
            addCriterion("POST_REQ like", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqNotLike(String value) {
            addCriterion("POST_REQ not like", value, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqIn(List<String> values) {
            addCriterion("POST_REQ in", values, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqNotIn(List<String> values) {
            addCriterion("POST_REQ not in", values, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqBetween(String value1, String value2) {
            addCriterion("POST_REQ between", value1, value2, "postReq");
            return (Criteria) this;
        }

        public Criteria andPostReqNotBetween(String value1, String value2) {
            addCriterion("POST_REQ not between", value1, value2, "postReq");
            return (Criteria) this;
        }

        public Criteria andOtherMgsIsNull() {
            addCriterion("OTHER_MGS is null");
            return (Criteria) this;
        }

        public Criteria andOtherMgsIsNotNull() {
            addCriterion("OTHER_MGS is not null");
            return (Criteria) this;
        }

        public Criteria andOtherMgsEqualTo(String value) {
            addCriterion("OTHER_MGS =", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsNotEqualTo(String value) {
            addCriterion("OTHER_MGS <>", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsGreaterThan(String value) {
            addCriterion("OTHER_MGS >", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_MGS >=", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsLessThan(String value) {
            addCriterion("OTHER_MGS <", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsLessThanOrEqualTo(String value) {
            addCriterion("OTHER_MGS <=", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsLike(String value) {
            addCriterion("OTHER_MGS like", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsNotLike(String value) {
            addCriterion("OTHER_MGS not like", value, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsIn(List<String> values) {
            addCriterion("OTHER_MGS in", values, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsNotIn(List<String> values) {
            addCriterion("OTHER_MGS not in", values, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsBetween(String value1, String value2) {
            addCriterion("OTHER_MGS between", value1, value2, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andOtherMgsNotBetween(String value1, String value2) {
            addCriterion("OTHER_MGS not between", value1, value2, "otherMgs");
            return (Criteria) this;
        }

        public Criteria andResumeIsNull() {
            addCriterion("RESUME is null");
            return (Criteria) this;
        }

        public Criteria andResumeIsNotNull() {
            addCriterion("RESUME is not null");
            return (Criteria) this;
        }

        public Criteria andResumeEqualTo(String value) {
            addCriterion("RESUME =", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotEqualTo(String value) {
            addCriterion("RESUME <>", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThan(String value) {
            addCriterion("RESUME >", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeGreaterThanOrEqualTo(String value) {
            addCriterion("RESUME >=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThan(String value) {
            addCriterion("RESUME <", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLessThanOrEqualTo(String value) {
            addCriterion("RESUME <=", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeLike(String value) {
            addCriterion("RESUME like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotLike(String value) {
            addCriterion("RESUME not like", value, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeIn(List<String> values) {
            addCriterion("RESUME in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotIn(List<String> values) {
            addCriterion("RESUME not in", values, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeBetween(String value1, String value2) {
            addCriterion("RESUME between", value1, value2, "resume");
            return (Criteria) this;
        }

        public Criteria andResumeNotBetween(String value1, String value2) {
            addCriterion("RESUME not between", value1, value2, "resume");
            return (Criteria) this;
        }

        public Criteria andJobBeginIsNull() {
            addCriterion("JOB_BEGIN is null");
            return (Criteria) this;
        }

        public Criteria andJobBeginIsNotNull() {
            addCriterion("JOB_BEGIN is not null");
            return (Criteria) this;
        }

        public Criteria andJobBeginEqualTo(Date value) {
            addCriterion("JOB_BEGIN =", value, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginNotEqualTo(Date value) {
            addCriterion("JOB_BEGIN <>", value, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginGreaterThan(Date value) {
            addCriterion("JOB_BEGIN >", value, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_BEGIN >=", value, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginLessThan(Date value) {
            addCriterion("JOB_BEGIN <", value, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginLessThanOrEqualTo(Date value) {
            addCriterion("JOB_BEGIN <=", value, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginIn(List<Date> values) {
            addCriterion("JOB_BEGIN in", values, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginNotIn(List<Date> values) {
            addCriterion("JOB_BEGIN not in", values, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginBetween(Date value1, Date value2) {
            addCriterion("JOB_BEGIN between", value1, value2, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobBeginNotBetween(Date value1, Date value2) {
            addCriterion("JOB_BEGIN not between", value1, value2, "jobBegin");
            return (Criteria) this;
        }

        public Criteria andJobEndIsNull() {
            addCriterion("JOB_END is null");
            return (Criteria) this;
        }

        public Criteria andJobEndIsNotNull() {
            addCriterion("JOB_END is not null");
            return (Criteria) this;
        }

        public Criteria andJobEndEqualTo(Date value) {
            addCriterion("JOB_END =", value, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndNotEqualTo(Date value) {
            addCriterion("JOB_END <>", value, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndGreaterThan(Date value) {
            addCriterion("JOB_END >", value, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_END >=", value, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndLessThan(Date value) {
            addCriterion("JOB_END <", value, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndLessThanOrEqualTo(Date value) {
            addCriterion("JOB_END <=", value, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndIn(List<Date> values) {
            addCriterion("JOB_END in", values, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndNotIn(List<Date> values) {
            addCriterion("JOB_END not in", values, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndBetween(Date value1, Date value2) {
            addCriterion("JOB_END between", value1, value2, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andJobEndNotBetween(Date value1, Date value2) {
            addCriterion("JOB_END not between", value1, value2, "jobEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndIsNull() {
            addCriterion("ENROLL_END is null");
            return (Criteria) this;
        }

        public Criteria andEnrollEndIsNotNull() {
            addCriterion("ENROLL_END is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollEndEqualTo(Date value) {
            addCriterion("ENROLL_END =", value, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndNotEqualTo(Date value) {
            addCriterion("ENROLL_END <>", value, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndGreaterThan(Date value) {
            addCriterion("ENROLL_END >", value, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndGreaterThanOrEqualTo(Date value) {
            addCriterion("ENROLL_END >=", value, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndLessThan(Date value) {
            addCriterion("ENROLL_END <", value, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndLessThanOrEqualTo(Date value) {
            addCriterion("ENROLL_END <=", value, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndIn(List<Date> values) {
            addCriterion("ENROLL_END in", values, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndNotIn(List<Date> values) {
            addCriterion("ENROLL_END not in", values, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndBetween(Date value1, Date value2) {
            addCriterion("ENROLL_END between", value1, value2, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andEnrollEndNotBetween(Date value1, Date value2) {
            addCriterion("ENROLL_END not between", value1, value2, "enrollEnd");
            return (Criteria) this;
        }

        public Criteria andPubUserIsNull() {
            addCriterion("PUB_USER is null");
            return (Criteria) this;
        }

        public Criteria andPubUserIsNotNull() {
            addCriterion("PUB_USER is not null");
            return (Criteria) this;
        }

        public Criteria andPubUserEqualTo(String value) {
            addCriterion("PUB_USER =", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserNotEqualTo(String value) {
            addCriterion("PUB_USER <>", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserGreaterThan(String value) {
            addCriterion("PUB_USER >", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserGreaterThanOrEqualTo(String value) {
            addCriterion("PUB_USER >=", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserLessThan(String value) {
            addCriterion("PUB_USER <", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserLessThanOrEqualTo(String value) {
            addCriterion("PUB_USER <=", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserLike(String value) {
            addCriterion("PUB_USER like", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserNotLike(String value) {
            addCriterion("PUB_USER not like", value, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserIn(List<String> values) {
            addCriterion("PUB_USER in", values, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserNotIn(List<String> values) {
            addCriterion("PUB_USER not in", values, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserBetween(String value1, String value2) {
            addCriterion("PUB_USER between", value1, value2, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubUserNotBetween(String value1, String value2) {
            addCriterion("PUB_USER not between", value1, value2, "pubUser");
            return (Criteria) this;
        }

        public Criteria andPubOrgIsNull() {
            addCriterion("PUB_ORG is null");
            return (Criteria) this;
        }

        public Criteria andPubOrgIsNotNull() {
            addCriterion("PUB_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andPubOrgEqualTo(String value) {
            addCriterion("PUB_ORG =", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgNotEqualTo(String value) {
            addCriterion("PUB_ORG <>", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgGreaterThan(String value) {
            addCriterion("PUB_ORG >", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgGreaterThanOrEqualTo(String value) {
            addCriterion("PUB_ORG >=", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgLessThan(String value) {
            addCriterion("PUB_ORG <", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgLessThanOrEqualTo(String value) {
            addCriterion("PUB_ORG <=", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgLike(String value) {
            addCriterion("PUB_ORG like", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgNotLike(String value) {
            addCriterion("PUB_ORG not like", value, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgIn(List<String> values) {
            addCriterion("PUB_ORG in", values, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgNotIn(List<String> values) {
            addCriterion("PUB_ORG not in", values, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgBetween(String value1, String value2) {
            addCriterion("PUB_ORG between", value1, value2, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andPubOrgNotBetween(String value1, String value2) {
            addCriterion("PUB_ORG not between", value1, value2, "pubOrg");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("CREATER is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("CREATER is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("CREATER =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("CREATER <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("CREATER >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("CREATER >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("CREATER <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("CREATER <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("CREATER like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("CREATER not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("CREATER in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("CREATER not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("CREATER between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("CREATER not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("UPDATER is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("UPDATER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("UPDATER =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("UPDATER <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("UPDATER >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATER >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("UPDATER <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("UPDATER <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("UPDATER like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("UPDATER not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("UPDATER in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("UPDATER not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("UPDATER between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("UPDATER not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}