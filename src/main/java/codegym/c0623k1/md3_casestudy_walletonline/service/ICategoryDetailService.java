package codegym.c0623k1.md3_casestudy_walletonline.service;

import codegym.c0623k1.md3_casestudy_walletonline.model.CategoryDetail;

import java.util.List;

public interface ICategoryDetailService extends IGeneralService<CategoryDetail> {
    List<CategoryDetail> findAllByCategoryID(int categoryID);
}
