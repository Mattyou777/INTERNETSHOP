package com.epam.internetshop.services.impl;

import com.epam.internetshop.DAO.DAOFactory;
import com.epam.internetshop.DAO.ProductDAO;
import com.epam.internetshop.DAO.impl.HibernateDAOFactory;
import com.epam.internetshop.domain.Product;
import com.epam.internetshop.services.ProductService;
import com.epam.internetshop.services.exception.ProductException;
import com.epam.internetshop.services.manager.ServiceFactory;
import com.epam.internetshop.services.validator.ProductValidator;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final DAOFactory daoFactory = new HibernateDAOFactory();

    private ProductDAO productDAO = daoFactory.newProductDAO();
    private ProductValidator productValidator = ServiceFactory.newProductValidator();

    public Product create(Product product) {
        if (product == null || !productValidator.validateAll(product))
            return null;
        return productDAO.create(product);
    }

    public Product update(Product product) {
        if (product == null || !productValidator.validateAll(product))
            return null;
        return productDAO.update(product);
    }

    public void delete(Product product) {
        productDAO.delete(product);
    }

    public List<Product> getAll() {
        return productDAO.getAll();
    }

    public Product getById(Long Id) {
        return productDAO.getById(Id);
    }

    public boolean isEnoughProduct(Long productId, Long productQuantity) {
        Long count = productDAO.getCount(productId);
        if (count == null)
            throw new ProductException("Not enough product available.");
        return count >= productQuantity;
    }

    public List<Product> getAllNameSorted(boolean isAsc) {
        return productDAO.getAllSorted("name", isAsc);
    }

    public List<Product> getAllPriceSorted(boolean isAsc) {
        return productDAO.getAllSorted("price", isAsc);
    }

    public List<Product> getAllCountSorted(boolean isAsc) {
        return productDAO.getAllSorted("count", isAsc);
    }
}
