package .service.impl;

import .entity.ApiResource;
import .entity.vo.ApiResourceVo;
import .entity.ApiResourceExample;
import .entity.dto.*;
import .mapper.ApiResourceMapper;
import .service.ApiResourceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 * @author wzn
 * @since 2020-04-13 19:16:38
 */
@Service("apiResourceService")
public class ApiResourceServiceImpl implements ApiResourceService {
    @Resource
    private ApiResourceMapper apiResourceMapper;

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ApiResourceVo queryApiResourceById(Long id) {
        ApiResourceExample example = new ApiResourceExample();
        example.createCriteria().andIdEqualTo(id);
        ApiResource apiResource =this.apiResourceMapper.selectOneByExample(id);
        ApiResourceVo vo = new ApiResourceVo();
        BeanUtils.copyProperties(apiResource,vo);
        return vo;
    }

    /**
     * 按条件查询分页
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<ApiResourceVo> queryApiResourceByConditionPage(Object object,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ApiResourceExample example = new ApiResourceExample();
        List<ApiResource> apiResourceList = this.apiResourceMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(apiResourceList)){
            return null;
        }
        List<ApiResourceVo>  apiResourceVoList= new ArrayList<>(apiResourceList.size());
        apiResourceList.stream().forEach(p->{
            ApiResourceVo apiResourceVo = new ApiResourceVo();
            BeanUtils.copyProperties(p,apiResourceVo);
            apiResourceVoList.add(apiResourceVo);
        });
        return apiResourceVoList;
    }
    /**
     * 按条件查询
     * @return 对象列表
     */
    @Override
    public List<ApiResourceVo> queryApiResourceByCondition(Object object) {
        ApiResourceExample example = new ApiResourceExample();
        List<ApiResource> apiResourceList =this.apiResourceMapper.selectByExample(example);    
        if(CollectionUtils.isEmpty(apiResourceList)){
            return null;
        }
        List<ApiResourceVo>  apiResourceVoList= new ArrayList<>(apiResourceList.size());
        apiResourceList.stream().forEach(p->{
            ApiResourceVo apiResourceVo = new ApiResourceVo();
            BeanUtils.copyProperties(p,apiResourceVo);
            apiResourceVoList.add(apiResourceVo);
        });
        return apiResourceVoList;
    }
    /**
     * 新增数据
     * @param apiResourceDto 实例对象
     * @return 实例对象
     */
    @Override
    public ApiResourceVo add(ApiResourceDto apiResourceDto) {
        ApiResource apiResource = new ApiResource();
        BeanUtils.copyProperties(apiResourceDto,apiResource);
        this.apiResourceMapper.insertUseGeneratedKeys(apiResource);
        ApiResourceVo vo = new ApiResourceVo();
        BeanUtils.copyProperties(apiResource,vo);
        return vo;
    }

    /**
     * 修改数据
     * @param apiResourceDto 实例对象
     * @return 实例对象
     */
    @Override
    public boolean edit(ApiResourceDto apiResourceDto) {
     ApiResource apiResource = new ApiResource();
      BeanUtils.copyProperties(apiResourceDto,apiResource);
     return this.apiResourceMapper.updateByPrimaryKeySelective(apiResource)>0;
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        ApiResourceExample example = new ApiResourceExample();
        example.createCriteria().andIdEqualTo(id);
        return this.apiResourceMapper.deleteByPrimaryKey(example) > 0;
    }
}