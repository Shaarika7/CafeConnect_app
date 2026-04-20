package com.jfs.training.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jfs.training.bean.FoodItemBean;
import com.jfs.training.entity.FoodItemEntity;

/*
 * Repository wrapper for FoodItemEntity.
 * This class acts as a DAO wrapper providing higher level operations using
 * FoodItemDAO. It also handles conversion between entity and bean objects.
 */
@Repository
@Transactional(transactionManager = "txManager")
public class FoodItemDAOWrapper {

	/* DAO for FoodItemEntity providing CRUD operations. */
	@Autowired
	private FoodItemDAO foodItemDAO;

	/**
	 * To-Do Item 1.2:
	 * --This method should add new food items to database.
	 * NOTE: This requirement needs to be implemented using Spring JPA Data.
	 * -- Convert FoodItemBean To Entity and vice versa as applicable(Hint: Utilize
	 * provided utility methods)
	 * -- Return the newly added food item.
	 * completed...1.2
	 **/

	public FoodItemBean addFoodItem(FoodItemBean bean) {

    if (bean == null) {
        throw new RuntimeException("FoodItem cannot be null");
    }

    FoodItemEntity entity = convertFoodItemBeanToEntity(bean);

    FoodItemEntity savedEntity = foodItemDAO.save(entity);

    return convertFoodItemEntityToBean(savedEntity);
}

	/**
	 * To-Do Item 1.3: This method should fetch all food items from database.
	 * NOTE: This requirement needs to be implemented using Spring JPA Data.
	 * TODO:
	 * --Fetch all food item details from the database
	 * --Convert all FoodItemEntities into FoodtemBeans and store them in list
	 * -- Return the list of FoodItemBeans
	 * completed... 1.3
	 */
	public List<FoodItemBean> getAllFoodItems() {

    List<FoodItemEntity> list = foodItemDAO.findAll();

    List<FoodItemBean> result = new ArrayList<>();

    for (FoodItemEntity entity : list) {
        result.add(convertFoodItemEntityToBean(entity));
    }

    return result;
}

	/* Converts FoodItemEntity to FoodItemBean */
	public static FoodItemBean convertFoodItemEntityToBean(FoodItemEntity entity) {
		FoodItemBean employee = new FoodItemBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}

	/* Converts FoodItemBean to FoodItemEntity */
	public static FoodItemEntity convertFoodItemBeanToEntity(FoodItemBean bean) {
		FoodItemEntity foodItemEntityBean = new FoodItemEntity();
		BeanUtils.copyProperties(bean, foodItemEntityBean);
		return foodItemEntityBean;
	}
}
