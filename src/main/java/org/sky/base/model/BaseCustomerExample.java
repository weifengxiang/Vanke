package org.sky.base.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class BaseCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public BaseCustomerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("AGE like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("AGE not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNull() {
            addCriterion("HOBBY is null");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNotNull() {
            addCriterion("HOBBY is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyEqualTo(String value) {
            addCriterion("HOBBY =", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotEqualTo(String value) {
            addCriterion("HOBBY <>", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThan(String value) {
            addCriterion("HOBBY >", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("HOBBY >=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThan(String value) {
            addCriterion("HOBBY <", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThanOrEqualTo(String value) {
            addCriterion("HOBBY <=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLike(String value) {
            addCriterion("HOBBY like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotLike(String value) {
            addCriterion("HOBBY not like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyIn(List<String> values) {
            addCriterion("HOBBY in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotIn(List<String> values) {
            addCriterion("HOBBY not in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyBetween(String value1, String value2) {
            addCriterion("HOBBY between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotBetween(String value1, String value2) {
            addCriterion("HOBBY not between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andCareerTypeIsNull() {
            addCriterion("CAREER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCareerTypeIsNotNull() {
            addCriterion("CAREER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCareerTypeEqualTo(String value) {
            addCriterion("CAREER_TYPE =", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeNotEqualTo(String value) {
            addCriterion("CAREER_TYPE <>", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeGreaterThan(String value) {
            addCriterion("CAREER_TYPE >", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CAREER_TYPE >=", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeLessThan(String value) {
            addCriterion("CAREER_TYPE <", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeLessThanOrEqualTo(String value) {
            addCriterion("CAREER_TYPE <=", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeLike(String value) {
            addCriterion("CAREER_TYPE like", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeNotLike(String value) {
            addCriterion("CAREER_TYPE not like", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeIn(List<String> values) {
            addCriterion("CAREER_TYPE in", values, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeNotIn(List<String> values) {
            addCriterion("CAREER_TYPE not in", values, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeBetween(String value1, String value2) {
            addCriterion("CAREER_TYPE between", value1, value2, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeNotBetween(String value1, String value2) {
            addCriterion("CAREER_TYPE not between", value1, value2, "careerType");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNull() {
            addCriterion("WORK_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNotNull() {
            addCriterion("WORK_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitEqualTo(String value) {
            addCriterion("WORK_UNIT =", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotEqualTo(String value) {
            addCriterion("WORK_UNIT <>", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThan(String value) {
            addCriterion("WORK_UNIT >", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_UNIT >=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThan(String value) {
            addCriterion("WORK_UNIT <", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThanOrEqualTo(String value) {
            addCriterion("WORK_UNIT <=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLike(String value) {
            addCriterion("WORK_UNIT like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotLike(String value) {
            addCriterion("WORK_UNIT not like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIn(List<String> values) {
            addCriterion("WORK_UNIT in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotIn(List<String> values) {
            addCriterion("WORK_UNIT not in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitBetween(String value1, String value2) {
            addCriterion("WORK_UNIT between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotBetween(String value1, String value2) {
            addCriterion("WORK_UNIT not between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andPositionLevelIsNull() {
            addCriterion("POSITION_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andPositionLevelIsNotNull() {
            addCriterion("POSITION_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andPositionLevelEqualTo(String value) {
            addCriterion("POSITION_LEVEL =", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotEqualTo(String value) {
            addCriterion("POSITION_LEVEL <>", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelGreaterThan(String value) {
            addCriterion("POSITION_LEVEL >", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION_LEVEL >=", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelLessThan(String value) {
            addCriterion("POSITION_LEVEL <", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelLessThanOrEqualTo(String value) {
            addCriterion("POSITION_LEVEL <=", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelLike(String value) {
            addCriterion("POSITION_LEVEL like", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotLike(String value) {
            addCriterion("POSITION_LEVEL not like", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelIn(List<String> values) {
            addCriterion("POSITION_LEVEL in", values, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotIn(List<String> values) {
            addCriterion("POSITION_LEVEL not in", values, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelBetween(String value1, String value2) {
            addCriterion("POSITION_LEVEL between", value1, value2, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotBetween(String value1, String value2) {
            addCriterion("POSITION_LEVEL not between", value1, value2, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNull() {
            addCriterion("MONTH_INCOME is null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNotNull() {
            addCriterion("MONTH_INCOME is not null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeEqualTo(String value) {
            addCriterion("MONTH_INCOME =", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotEqualTo(String value) {
            addCriterion("MONTH_INCOME <>", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThan(String value) {
            addCriterion("MONTH_INCOME >", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("MONTH_INCOME >=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThan(String value) {
            addCriterion("MONTH_INCOME <", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThanOrEqualTo(String value) {
            addCriterion("MONTH_INCOME <=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLike(String value) {
            addCriterion("MONTH_INCOME like", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotLike(String value) {
            addCriterion("MONTH_INCOME not like", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIn(List<String> values) {
            addCriterion("MONTH_INCOME in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotIn(List<String> values) {
            addCriterion("MONTH_INCOME not in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeBetween(String value1, String value2) {
            addCriterion("MONTH_INCOME between", value1, value2, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotBetween(String value1, String value2) {
            addCriterion("MONTH_INCOME not between", value1, value2, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("MARRIAGE is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("MARRIAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("MARRIAGE =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("MARRIAGE <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("MARRIAGE >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("MARRIAGE >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("MARRIAGE <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("MARRIAGE <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("MARRIAGE like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("MARRIAGE not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("MARRIAGE in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("MARRIAGE not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("MARRIAGE between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("MARRIAGE not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerIsNull() {
            addCriterion("SPOUSE_CAREER is null");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerIsNotNull() {
            addCriterion("SPOUSE_CAREER is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerEqualTo(String value) {
            addCriterion("SPOUSE_CAREER =", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerNotEqualTo(String value) {
            addCriterion("SPOUSE_CAREER <>", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerGreaterThan(String value) {
            addCriterion("SPOUSE_CAREER >", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerGreaterThanOrEqualTo(String value) {
            addCriterion("SPOUSE_CAREER >=", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerLessThan(String value) {
            addCriterion("SPOUSE_CAREER <", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerLessThanOrEqualTo(String value) {
            addCriterion("SPOUSE_CAREER <=", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerLike(String value) {
            addCriterion("SPOUSE_CAREER like", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerNotLike(String value) {
            addCriterion("SPOUSE_CAREER not like", value, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerIn(List<String> values) {
            addCriterion("SPOUSE_CAREER in", values, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerNotIn(List<String> values) {
            addCriterion("SPOUSE_CAREER not in", values, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerBetween(String value1, String value2) {
            addCriterion("SPOUSE_CAREER between", value1, value2, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseCareerNotBetween(String value1, String value2) {
            addCriterion("SPOUSE_CAREER not between", value1, value2, "spouseCareer");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitIsNull() {
            addCriterion("SPOUSE_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitIsNotNull() {
            addCriterion("SPOUSE_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitEqualTo(String value) {
            addCriterion("SPOUSE_UNIT =", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitNotEqualTo(String value) {
            addCriterion("SPOUSE_UNIT <>", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitGreaterThan(String value) {
            addCriterion("SPOUSE_UNIT >", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitGreaterThanOrEqualTo(String value) {
            addCriterion("SPOUSE_UNIT >=", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitLessThan(String value) {
            addCriterion("SPOUSE_UNIT <", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitLessThanOrEqualTo(String value) {
            addCriterion("SPOUSE_UNIT <=", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitLike(String value) {
            addCriterion("SPOUSE_UNIT like", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitNotLike(String value) {
            addCriterion("SPOUSE_UNIT not like", value, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitIn(List<String> values) {
            addCriterion("SPOUSE_UNIT in", values, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitNotIn(List<String> values) {
            addCriterion("SPOUSE_UNIT not in", values, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitBetween(String value1, String value2) {
            addCriterion("SPOUSE_UNIT between", value1, value2, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andSpouseUnitNotBetween(String value1, String value2) {
            addCriterion("SPOUSE_UNIT not between", value1, value2, "spouseUnit");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureIsNull() {
            addCriterion("FAMILY_STRUCTURE is null");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureIsNotNull() {
            addCriterion("FAMILY_STRUCTURE is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureEqualTo(String value) {
            addCriterion("FAMILY_STRUCTURE =", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureNotEqualTo(String value) {
            addCriterion("FAMILY_STRUCTURE <>", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureGreaterThan(String value) {
            addCriterion("FAMILY_STRUCTURE >", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureGreaterThanOrEqualTo(String value) {
            addCriterion("FAMILY_STRUCTURE >=", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureLessThan(String value) {
            addCriterion("FAMILY_STRUCTURE <", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureLessThanOrEqualTo(String value) {
            addCriterion("FAMILY_STRUCTURE <=", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureLike(String value) {
            addCriterion("FAMILY_STRUCTURE like", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureNotLike(String value) {
            addCriterion("FAMILY_STRUCTURE not like", value, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureIn(List<String> values) {
            addCriterion("FAMILY_STRUCTURE in", values, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureNotIn(List<String> values) {
            addCriterion("FAMILY_STRUCTURE not in", values, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureBetween(String value1, String value2) {
            addCriterion("FAMILY_STRUCTURE between", value1, value2, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyStructureNotBetween(String value1, String value2) {
            addCriterion("FAMILY_STRUCTURE not between", value1, value2, "familyStructure");
            return (Criteria) this;
        }

        public Criteria andFamilyNumIsNull() {
            addCriterion("FAMILY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFamilyNumIsNotNull() {
            addCriterion("FAMILY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyNumEqualTo(Integer value) {
            addCriterion("FAMILY_NUM =", value, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumNotEqualTo(Integer value) {
            addCriterion("FAMILY_NUM <>", value, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumGreaterThan(Integer value) {
            addCriterion("FAMILY_NUM >", value, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAMILY_NUM >=", value, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumLessThan(Integer value) {
            addCriterion("FAMILY_NUM <", value, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumLessThanOrEqualTo(Integer value) {
            addCriterion("FAMILY_NUM <=", value, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumIn(List<Integer> values) {
            addCriterion("FAMILY_NUM in", values, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumNotIn(List<Integer> values) {
            addCriterion("FAMILY_NUM not in", values, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumBetween(Integer value1, Integer value2) {
            addCriterion("FAMILY_NUM between", value1, value2, "familyNum");
            return (Criteria) this;
        }

        public Criteria andFamilyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("FAMILY_NUM not between", value1, value2, "familyNum");
            return (Criteria) this;
        }

        public Criteria andChildAgeIsNull() {
            addCriterion("CHILD_AGE is null");
            return (Criteria) this;
        }

        public Criteria andChildAgeIsNotNull() {
            addCriterion("CHILD_AGE is not null");
            return (Criteria) this;
        }

        public Criteria andChildAgeEqualTo(Integer value) {
            addCriterion("CHILD_AGE =", value, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeNotEqualTo(Integer value) {
            addCriterion("CHILD_AGE <>", value, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeGreaterThan(Integer value) {
            addCriterion("CHILD_AGE >", value, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHILD_AGE >=", value, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeLessThan(Integer value) {
            addCriterion("CHILD_AGE <", value, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeLessThanOrEqualTo(Integer value) {
            addCriterion("CHILD_AGE <=", value, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeIn(List<Integer> values) {
            addCriterion("CHILD_AGE in", values, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeNotIn(List<Integer> values) {
            addCriterion("CHILD_AGE not in", values, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeBetween(Integer value1, Integer value2) {
            addCriterion("CHILD_AGE between", value1, value2, "childAge");
            return (Criteria) this;
        }

        public Criteria andChildAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("CHILD_AGE not between", value1, value2, "childAge");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceIsNull() {
            addCriterion("LIVING_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceIsNotNull() {
            addCriterion("LIVING_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceEqualTo(String value) {
            addCriterion("LIVING_PROVINCE =", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceNotEqualTo(String value) {
            addCriterion("LIVING_PROVINCE <>", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceGreaterThan(String value) {
            addCriterion("LIVING_PROVINCE >", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("LIVING_PROVINCE >=", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceLessThan(String value) {
            addCriterion("LIVING_PROVINCE <", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceLessThanOrEqualTo(String value) {
            addCriterion("LIVING_PROVINCE <=", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceLike(String value) {
            addCriterion("LIVING_PROVINCE like", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceNotLike(String value) {
            addCriterion("LIVING_PROVINCE not like", value, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceIn(List<String> values) {
            addCriterion("LIVING_PROVINCE in", values, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceNotIn(List<String> values) {
            addCriterion("LIVING_PROVINCE not in", values, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceBetween(String value1, String value2) {
            addCriterion("LIVING_PROVINCE between", value1, value2, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingProvinceNotBetween(String value1, String value2) {
            addCriterion("LIVING_PROVINCE not between", value1, value2, "livingProvince");
            return (Criteria) this;
        }

        public Criteria andLivingCityIsNull() {
            addCriterion("LIVING_CITY is null");
            return (Criteria) this;
        }

        public Criteria andLivingCityIsNotNull() {
            addCriterion("LIVING_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andLivingCityEqualTo(String value) {
            addCriterion("LIVING_CITY =", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityNotEqualTo(String value) {
            addCriterion("LIVING_CITY <>", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityGreaterThan(String value) {
            addCriterion("LIVING_CITY >", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityGreaterThanOrEqualTo(String value) {
            addCriterion("LIVING_CITY >=", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityLessThan(String value) {
            addCriterion("LIVING_CITY <", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityLessThanOrEqualTo(String value) {
            addCriterion("LIVING_CITY <=", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityLike(String value) {
            addCriterion("LIVING_CITY like", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityNotLike(String value) {
            addCriterion("LIVING_CITY not like", value, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityIn(List<String> values) {
            addCriterion("LIVING_CITY in", values, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityNotIn(List<String> values) {
            addCriterion("LIVING_CITY not in", values, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityBetween(String value1, String value2) {
            addCriterion("LIVING_CITY between", value1, value2, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingCityNotBetween(String value1, String value2) {
            addCriterion("LIVING_CITY not between", value1, value2, "livingCity");
            return (Criteria) this;
        }

        public Criteria andLivingAreaIsNull() {
            addCriterion("LIVING_AREA is null");
            return (Criteria) this;
        }

        public Criteria andLivingAreaIsNotNull() {
            addCriterion("LIVING_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andLivingAreaEqualTo(String value) {
            addCriterion("LIVING_AREA =", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaNotEqualTo(String value) {
            addCriterion("LIVING_AREA <>", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaGreaterThan(String value) {
            addCriterion("LIVING_AREA >", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("LIVING_AREA >=", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaLessThan(String value) {
            addCriterion("LIVING_AREA <", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaLessThanOrEqualTo(String value) {
            addCriterion("LIVING_AREA <=", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaLike(String value) {
            addCriterion("LIVING_AREA like", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaNotLike(String value) {
            addCriterion("LIVING_AREA not like", value, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaIn(List<String> values) {
            addCriterion("LIVING_AREA in", values, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaNotIn(List<String> values) {
            addCriterion("LIVING_AREA not in", values, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaBetween(String value1, String value2) {
            addCriterion("LIVING_AREA between", value1, value2, "livingArea");
            return (Criteria) this;
        }

        public Criteria andLivingAreaNotBetween(String value1, String value2) {
            addCriterion("LIVING_AREA not between", value1, value2, "livingArea");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIsNull() {
            addCriterion("FAMILY_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIsNotNull() {
            addCriterion("FAMILY_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressEqualTo(String value) {
            addCriterion("FAMILY_ADDRESS =", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotEqualTo(String value) {
            addCriterion("FAMILY_ADDRESS <>", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressGreaterThan(String value) {
            addCriterion("FAMILY_ADDRESS >", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("FAMILY_ADDRESS >=", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLessThan(String value) {
            addCriterion("FAMILY_ADDRESS <", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLessThanOrEqualTo(String value) {
            addCriterion("FAMILY_ADDRESS <=", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressLike(String value) {
            addCriterion("FAMILY_ADDRESS like", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotLike(String value) {
            addCriterion("FAMILY_ADDRESS not like", value, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressIn(List<String> values) {
            addCriterion("FAMILY_ADDRESS in", values, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotIn(List<String> values) {
            addCriterion("FAMILY_ADDRESS not in", values, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressBetween(String value1, String value2) {
            addCriterion("FAMILY_ADDRESS between", value1, value2, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyAddressNotBetween(String value1, String value2) {
            addCriterion("FAMILY_ADDRESS not between", value1, value2, "familyAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIsNull() {
            addCriterion("WORK_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIsNotNull() {
            addCriterion("WORK_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAddressEqualTo(String value) {
            addCriterion("WORK_ADDRESS =", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotEqualTo(String value) {
            addCriterion("WORK_ADDRESS <>", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressGreaterThan(String value) {
            addCriterion("WORK_ADDRESS >", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ADDRESS >=", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLessThan(String value) {
            addCriterion("WORK_ADDRESS <", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLessThanOrEqualTo(String value) {
            addCriterion("WORK_ADDRESS <=", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressLike(String value) {
            addCriterion("WORK_ADDRESS like", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotLike(String value) {
            addCriterion("WORK_ADDRESS not like", value, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressIn(List<String> values) {
            addCriterion("WORK_ADDRESS in", values, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotIn(List<String> values) {
            addCriterion("WORK_ADDRESS not in", values, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressBetween(String value1, String value2) {
            addCriterion("WORK_ADDRESS between", value1, value2, "workAddress");
            return (Criteria) this;
        }

        public Criteria andWorkAddressNotBetween(String value1, String value2) {
            addCriterion("WORK_ADDRESS not between", value1, value2, "workAddress");
            return (Criteria) this;
        }

        public Criteria andKnowWayIsNull() {
            addCriterion("KNOW_WAY is null");
            return (Criteria) this;
        }

        public Criteria andKnowWayIsNotNull() {
            addCriterion("KNOW_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andKnowWayEqualTo(String value) {
            addCriterion("KNOW_WAY =", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayNotEqualTo(String value) {
            addCriterion("KNOW_WAY <>", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayGreaterThan(String value) {
            addCriterion("KNOW_WAY >", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayGreaterThanOrEqualTo(String value) {
            addCriterion("KNOW_WAY >=", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayLessThan(String value) {
            addCriterion("KNOW_WAY <", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayLessThanOrEqualTo(String value) {
            addCriterion("KNOW_WAY <=", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayLike(String value) {
            addCriterion("KNOW_WAY like", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayNotLike(String value) {
            addCriterion("KNOW_WAY not like", value, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayIn(List<String> values) {
            addCriterion("KNOW_WAY in", values, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayNotIn(List<String> values) {
            addCriterion("KNOW_WAY not in", values, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayBetween(String value1, String value2) {
            addCriterion("KNOW_WAY between", value1, value2, "knowWay");
            return (Criteria) this;
        }

        public Criteria andKnowWayNotBetween(String value1, String value2) {
            addCriterion("KNOW_WAY not between", value1, value2, "knowWay");
            return (Criteria) this;
        }

        public Criteria andHousePurposeIsNull() {
            addCriterion("HOUSE_PURPOSE is null");
            return (Criteria) this;
        }

        public Criteria andHousePurposeIsNotNull() {
            addCriterion("HOUSE_PURPOSE is not null");
            return (Criteria) this;
        }

        public Criteria andHousePurposeEqualTo(String value) {
            addCriterion("HOUSE_PURPOSE =", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeNotEqualTo(String value) {
            addCriterion("HOUSE_PURPOSE <>", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeGreaterThan(String value) {
            addCriterion("HOUSE_PURPOSE >", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_PURPOSE >=", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeLessThan(String value) {
            addCriterion("HOUSE_PURPOSE <", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_PURPOSE <=", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeLike(String value) {
            addCriterion("HOUSE_PURPOSE like", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeNotLike(String value) {
            addCriterion("HOUSE_PURPOSE not like", value, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeIn(List<String> values) {
            addCriterion("HOUSE_PURPOSE in", values, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeNotIn(List<String> values) {
            addCriterion("HOUSE_PURPOSE not in", values, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeBetween(String value1, String value2) {
            addCriterion("HOUSE_PURPOSE between", value1, value2, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andHousePurposeNotBetween(String value1, String value2) {
            addCriterion("HOUSE_PURPOSE not between", value1, value2, "housePurpose");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetIsNull() {
            addCriterion("TOTAL_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetIsNotNull() {
            addCriterion("TOTAL_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetEqualTo(String value) {
            addCriterion("TOTAL_BUDGET =", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetNotEqualTo(String value) {
            addCriterion("TOTAL_BUDGET <>", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetGreaterThan(String value) {
            addCriterion("TOTAL_BUDGET >", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetGreaterThanOrEqualTo(String value) {
            addCriterion("TOTAL_BUDGET >=", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetLessThan(String value) {
            addCriterion("TOTAL_BUDGET <", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetLessThanOrEqualTo(String value) {
            addCriterion("TOTAL_BUDGET <=", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetLike(String value) {
            addCriterion("TOTAL_BUDGET like", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetNotLike(String value) {
            addCriterion("TOTAL_BUDGET not like", value, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetIn(List<String> values) {
            addCriterion("TOTAL_BUDGET in", values, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetNotIn(List<String> values) {
            addCriterion("TOTAL_BUDGET not in", values, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetBetween(String value1, String value2) {
            addCriterion("TOTAL_BUDGET between", value1, value2, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andTotalBudgetNotBetween(String value1, String value2) {
            addCriterion("TOTAL_BUDGET not between", value1, value2, "totalBudget");
            return (Criteria) this;
        }

        public Criteria andCreditConditionIsNull() {
            addCriterion("CREDIT_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andCreditConditionIsNotNull() {
            addCriterion("CREDIT_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andCreditConditionEqualTo(String value) {
            addCriterion("CREDIT_CONDITION =", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionNotEqualTo(String value) {
            addCriterion("CREDIT_CONDITION <>", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionGreaterThan(String value) {
            addCriterion("CREDIT_CONDITION >", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_CONDITION >=", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionLessThan(String value) {
            addCriterion("CREDIT_CONDITION <", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_CONDITION <=", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionLike(String value) {
            addCriterion("CREDIT_CONDITION like", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionNotLike(String value) {
            addCriterion("CREDIT_CONDITION not like", value, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionIn(List<String> values) {
            addCriterion("CREDIT_CONDITION in", values, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionNotIn(List<String> values) {
            addCriterion("CREDIT_CONDITION not in", values, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionBetween(String value1, String value2) {
            addCriterion("CREDIT_CONDITION between", value1, value2, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andCreditConditionNotBetween(String value1, String value2) {
            addCriterion("CREDIT_CONDITION not between", value1, value2, "creditCondition");
            return (Criteria) this;
        }

        public Criteria andTargetYtIsNull() {
            addCriterion("TARGET_YT is null");
            return (Criteria) this;
        }

        public Criteria andTargetYtIsNotNull() {
            addCriterion("TARGET_YT is not null");
            return (Criteria) this;
        }

        public Criteria andTargetYtEqualTo(String value) {
            addCriterion("TARGET_YT =", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtNotEqualTo(String value) {
            addCriterion("TARGET_YT <>", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtGreaterThan(String value) {
            addCriterion("TARGET_YT >", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_YT >=", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtLessThan(String value) {
            addCriterion("TARGET_YT <", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtLessThanOrEqualTo(String value) {
            addCriterion("TARGET_YT <=", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtLike(String value) {
            addCriterion("TARGET_YT like", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtNotLike(String value) {
            addCriterion("TARGET_YT not like", value, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtIn(List<String> values) {
            addCriterion("TARGET_YT in", values, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtNotIn(List<String> values) {
            addCriterion("TARGET_YT not in", values, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtBetween(String value1, String value2) {
            addCriterion("TARGET_YT between", value1, value2, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetYtNotBetween(String value1, String value2) {
            addCriterion("TARGET_YT not between", value1, value2, "targetYt");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutIsNull() {
            addCriterion("TARGET_LAYOUT is null");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutIsNotNull() {
            addCriterion("TARGET_LAYOUT is not null");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutEqualTo(String value) {
            addCriterion("TARGET_LAYOUT =", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutNotEqualTo(String value) {
            addCriterion("TARGET_LAYOUT <>", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutGreaterThan(String value) {
            addCriterion("TARGET_LAYOUT >", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_LAYOUT >=", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutLessThan(String value) {
            addCriterion("TARGET_LAYOUT <", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutLessThanOrEqualTo(String value) {
            addCriterion("TARGET_LAYOUT <=", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutLike(String value) {
            addCriterion("TARGET_LAYOUT like", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutNotLike(String value) {
            addCriterion("TARGET_LAYOUT not like", value, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutIn(List<String> values) {
            addCriterion("TARGET_LAYOUT in", values, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutNotIn(List<String> values) {
            addCriterion("TARGET_LAYOUT not in", values, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutBetween(String value1, String value2) {
            addCriterion("TARGET_LAYOUT between", value1, value2, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetLayoutNotBetween(String value1, String value2) {
            addCriterion("TARGET_LAYOUT not between", value1, value2, "targetLayout");
            return (Criteria) this;
        }

        public Criteria andTargetAreaIsNull() {
            addCriterion("TARGET_AREA is null");
            return (Criteria) this;
        }

        public Criteria andTargetAreaIsNotNull() {
            addCriterion("TARGET_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andTargetAreaEqualTo(String value) {
            addCriterion("TARGET_AREA =", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaNotEqualTo(String value) {
            addCriterion("TARGET_AREA <>", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaGreaterThan(String value) {
            addCriterion("TARGET_AREA >", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_AREA >=", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaLessThan(String value) {
            addCriterion("TARGET_AREA <", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaLessThanOrEqualTo(String value) {
            addCriterion("TARGET_AREA <=", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaLike(String value) {
            addCriterion("TARGET_AREA like", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaNotLike(String value) {
            addCriterion("TARGET_AREA not like", value, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaIn(List<String> values) {
            addCriterion("TARGET_AREA in", values, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaNotIn(List<String> values) {
            addCriterion("TARGET_AREA not in", values, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaBetween(String value1, String value2) {
            addCriterion("TARGET_AREA between", value1, value2, "targetArea");
            return (Criteria) this;
        }

        public Criteria andTargetAreaNotBetween(String value1, String value2) {
            addCriterion("TARGET_AREA not between", value1, value2, "targetArea");
            return (Criteria) this;
        }

        public Criteria andAcceptP1IsNull() {
            addCriterion("ACCEPT_P1 is null");
            return (Criteria) this;
        }

        public Criteria andAcceptP1IsNotNull() {
            addCriterion("ACCEPT_P1 is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptP1EqualTo(String value) {
            addCriterion("ACCEPT_P1 =", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1NotEqualTo(String value) {
            addCriterion("ACCEPT_P1 <>", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1GreaterThan(String value) {
            addCriterion("ACCEPT_P1 >", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1GreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_P1 >=", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1LessThan(String value) {
            addCriterion("ACCEPT_P1 <", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1LessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_P1 <=", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1Like(String value) {
            addCriterion("ACCEPT_P1 like", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1NotLike(String value) {
            addCriterion("ACCEPT_P1 not like", value, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1In(List<String> values) {
            addCriterion("ACCEPT_P1 in", values, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1NotIn(List<String> values) {
            addCriterion("ACCEPT_P1 not in", values, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1Between(String value1, String value2) {
            addCriterion("ACCEPT_P1 between", value1, value2, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP1NotBetween(String value1, String value2) {
            addCriterion("ACCEPT_P1 not between", value1, value2, "acceptP1");
            return (Criteria) this;
        }

        public Criteria andAcceptP2IsNull() {
            addCriterion("ACCEPT_P2 is null");
            return (Criteria) this;
        }

        public Criteria andAcceptP2IsNotNull() {
            addCriterion("ACCEPT_P2 is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptP2EqualTo(String value) {
            addCriterion("ACCEPT_P2 =", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2NotEqualTo(String value) {
            addCriterion("ACCEPT_P2 <>", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2GreaterThan(String value) {
            addCriterion("ACCEPT_P2 >", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2GreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_P2 >=", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2LessThan(String value) {
            addCriterion("ACCEPT_P2 <", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2LessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_P2 <=", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2Like(String value) {
            addCriterion("ACCEPT_P2 like", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2NotLike(String value) {
            addCriterion("ACCEPT_P2 not like", value, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2In(List<String> values) {
            addCriterion("ACCEPT_P2 in", values, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2NotIn(List<String> values) {
            addCriterion("ACCEPT_P2 not in", values, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2Between(String value1, String value2) {
            addCriterion("ACCEPT_P2 between", value1, value2, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP2NotBetween(String value1, String value2) {
            addCriterion("ACCEPT_P2 not between", value1, value2, "acceptP2");
            return (Criteria) this;
        }

        public Criteria andAcceptP3IsNull() {
            addCriterion("ACCEPT_P3 is null");
            return (Criteria) this;
        }

        public Criteria andAcceptP3IsNotNull() {
            addCriterion("ACCEPT_P3 is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptP3EqualTo(String value) {
            addCriterion("ACCEPT_P3 =", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3NotEqualTo(String value) {
            addCriterion("ACCEPT_P3 <>", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3GreaterThan(String value) {
            addCriterion("ACCEPT_P3 >", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3GreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_P3 >=", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3LessThan(String value) {
            addCriterion("ACCEPT_P3 <", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3LessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_P3 <=", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3Like(String value) {
            addCriterion("ACCEPT_P3 like", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3NotLike(String value) {
            addCriterion("ACCEPT_P3 not like", value, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3In(List<String> values) {
            addCriterion("ACCEPT_P3 in", values, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3NotIn(List<String> values) {
            addCriterion("ACCEPT_P3 not in", values, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3Between(String value1, String value2) {
            addCriterion("ACCEPT_P3 between", value1, value2, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andAcceptP3NotBetween(String value1, String value2) {
            addCriterion("ACCEPT_P3 not between", value1, value2, "acceptP3");
            return (Criteria) this;
        }

        public Criteria andResistanceIsNull() {
            addCriterion("RESISTANCE is null");
            return (Criteria) this;
        }

        public Criteria andResistanceIsNotNull() {
            addCriterion("RESISTANCE is not null");
            return (Criteria) this;
        }

        public Criteria andResistanceEqualTo(String value) {
            addCriterion("RESISTANCE =", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceNotEqualTo(String value) {
            addCriterion("RESISTANCE <>", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceGreaterThan(String value) {
            addCriterion("RESISTANCE >", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceGreaterThanOrEqualTo(String value) {
            addCriterion("RESISTANCE >=", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceLessThan(String value) {
            addCriterion("RESISTANCE <", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceLessThanOrEqualTo(String value) {
            addCriterion("RESISTANCE <=", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceLike(String value) {
            addCriterion("RESISTANCE like", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceNotLike(String value) {
            addCriterion("RESISTANCE not like", value, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceIn(List<String> values) {
            addCriterion("RESISTANCE in", values, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceNotIn(List<String> values) {
            addCriterion("RESISTANCE not in", values, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceBetween(String value1, String value2) {
            addCriterion("RESISTANCE between", value1, value2, "resistance");
            return (Criteria) this;
        }

        public Criteria andResistanceNotBetween(String value1, String value2) {
            addCriterion("RESISTANCE not between", value1, value2, "resistance");
            return (Criteria) this;
        }

        public Criteria andCompetitorIsNull() {
            addCriterion("COMPETITOR is null");
            return (Criteria) this;
        }

        public Criteria andCompetitorIsNotNull() {
            addCriterion("COMPETITOR is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitorEqualTo(String value) {
            addCriterion("COMPETITOR =", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotEqualTo(String value) {
            addCriterion("COMPETITOR <>", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorGreaterThan(String value) {
            addCriterion("COMPETITOR >", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorGreaterThanOrEqualTo(String value) {
            addCriterion("COMPETITOR >=", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorLessThan(String value) {
            addCriterion("COMPETITOR <", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorLessThanOrEqualTo(String value) {
            addCriterion("COMPETITOR <=", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorLike(String value) {
            addCriterion("COMPETITOR like", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotLike(String value) {
            addCriterion("COMPETITOR not like", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorIn(List<String> values) {
            addCriterion("COMPETITOR in", values, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotIn(List<String> values) {
            addCriterion("COMPETITOR not in", values, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorBetween(String value1, String value2) {
            addCriterion("COMPETITOR between", value1, value2, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotBetween(String value1, String value2) {
            addCriterion("COMPETITOR not between", value1, value2, "competitor");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNull() {
            addCriterion("VISIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNotNull() {
            addCriterion("VISIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEqualTo(Date value) {
            addCriterionForJDBCDate("VISIT_TIME =", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("VISIT_TIME <>", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("VISIT_TIME >", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("VISIT_TIME >=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThan(Date value) {
            addCriterionForJDBCDate("VISIT_TIME <", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("VISIT_TIME <=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIn(List<Date> values) {
            addCriterionForJDBCDate("VISIT_TIME in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("VISIT_TIME not in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("VISIT_TIME between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("VISIT_TIME not between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andSaleTeamIsNull() {
            addCriterion("SALE_TEAM is null");
            return (Criteria) this;
        }

        public Criteria andSaleTeamIsNotNull() {
            addCriterion("SALE_TEAM is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTeamEqualTo(String value) {
            addCriterion("SALE_TEAM =", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamNotEqualTo(String value) {
            addCriterion("SALE_TEAM <>", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamGreaterThan(String value) {
            addCriterion("SALE_TEAM >", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_TEAM >=", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamLessThan(String value) {
            addCriterion("SALE_TEAM <", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamLessThanOrEqualTo(String value) {
            addCriterion("SALE_TEAM <=", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamLike(String value) {
            addCriterion("SALE_TEAM like", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamNotLike(String value) {
            addCriterion("SALE_TEAM not like", value, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamIn(List<String> values) {
            addCriterion("SALE_TEAM in", values, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamNotIn(List<String> values) {
            addCriterion("SALE_TEAM not in", values, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamBetween(String value1, String value2) {
            addCriterion("SALE_TEAM between", value1, value2, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andSaleTeamNotBetween(String value1, String value2) {
            addCriterion("SALE_TEAM not between", value1, value2, "saleTeam");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantIsNull() {
            addCriterion("PROPERTY_CONSULTANT is null");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantIsNotNull() {
            addCriterion("PROPERTY_CONSULTANT is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantEqualTo(String value) {
            addCriterion("PROPERTY_CONSULTANT =", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantNotEqualTo(String value) {
            addCriterion("PROPERTY_CONSULTANT <>", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantGreaterThan(String value) {
            addCriterion("PROPERTY_CONSULTANT >", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY_CONSULTANT >=", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantLessThan(String value) {
            addCriterion("PROPERTY_CONSULTANT <", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantLessThanOrEqualTo(String value) {
            addCriterion("PROPERTY_CONSULTANT <=", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantLike(String value) {
            addCriterion("PROPERTY_CONSULTANT like", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantNotLike(String value) {
            addCriterion("PROPERTY_CONSULTANT not like", value, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantIn(List<String> values) {
            addCriterion("PROPERTY_CONSULTANT in", values, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantNotIn(List<String> values) {
            addCriterion("PROPERTY_CONSULTANT not in", values, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantBetween(String value1, String value2) {
            addCriterion("PROPERTY_CONSULTANT between", value1, value2, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andPropertyConsultantNotBetween(String value1, String value2) {
            addCriterion("PROPERTY_CONSULTANT not between", value1, value2, "propertyConsultant");
            return (Criteria) this;
        }

        public Criteria andRegistrantIsNull() {
            addCriterion("REGISTRANT is null");
            return (Criteria) this;
        }

        public Criteria andRegistrantIsNotNull() {
            addCriterion("REGISTRANT is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrantEqualTo(String value) {
            addCriterion("REGISTRANT =", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotEqualTo(String value) {
            addCriterion("REGISTRANT <>", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantGreaterThan(String value) {
            addCriterion("REGISTRANT >", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTRANT >=", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantLessThan(String value) {
            addCriterion("REGISTRANT <", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantLessThanOrEqualTo(String value) {
            addCriterion("REGISTRANT <=", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantLike(String value) {
            addCriterion("REGISTRANT like", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotLike(String value) {
            addCriterion("REGISTRANT not like", value, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantIn(List<String> values) {
            addCriterion("REGISTRANT in", values, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotIn(List<String> values) {
            addCriterion("REGISTRANT not in", values, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantBetween(String value1, String value2) {
            addCriterion("REGISTRANT between", value1, value2, "registrant");
            return (Criteria) this;
        }

        public Criteria andRegistrantNotBetween(String value1, String value2) {
            addCriterion("REGISTRANT not between", value1, value2, "registrant");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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