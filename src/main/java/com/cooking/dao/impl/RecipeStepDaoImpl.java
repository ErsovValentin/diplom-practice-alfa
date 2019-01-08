package com.cooking.dao.impl;

import com.cooking.dao.RecipeStepDao;
import com.cooking.model.Dish;
import com.cooking.model.RecipeStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RecipeStepDaoImpl implements RecipeStepDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RecipeStepDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<RecipeStep> getAllRecipeSteps() {
        return session()
                .createQuery("from RecipeStep ", RecipeStep.class)
                .list();
    }

    @Override
    public RecipeStep getRecipeStepById(int id) {
        return session()
                .get(RecipeStep.class, id);
    }

    @Override
    public void addRecipeStep(RecipeStep recipeStepAdd) {
        session().save(recipeStepAdd);
    }

    @Override
    public void updateRecipeStep(RecipeStep recipeStepUpdate) {
        session().merge(recipeStepUpdate);
    }

    @Override
    public void deleteRecipeStep(RecipeStep recipeStepDelete) {
        session().delete(recipeStepDelete);
    }

    @Override
    public List<RecipeStep> getRecipeStepsByDish(Dish dish) {
        return session()
                .createQuery("from RecipeStep as rs where rs.dish = ?1", RecipeStep.class)
                .setParameter(1, dish)
                .list();
    }
}
