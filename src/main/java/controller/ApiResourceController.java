package .controller;

import .entity.ApiResource;
import .service.ApiResourceService;
import .entity.vo.ApiResourceVo;
import .entity.dto.ApiResourceDto;
import .controller.feign.ApiResourceFeignService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层
 * @author wzn
 * @since 2020-04-13 19:16:38
 */
@RestController
@RequestMapping("apiResource")
@Api(tags = "(ApiResource)服务") 
public class ApiResourceController implements ApiResourceFeignService{
   
    @Resource
    private ApiResourceService apiResourceService;
 
    @Override
    public ApiResourceVo queryApiResourceById(@ApiParam(value = " ID") @PathVariable("id") Long id) {
        return this.apiResourceService.queryApiResourceById(id);
    }
    
    @Override
    public List<ApiResourceVo> queryApiResourceByConditionPage(Object object,int pageNum, int pageSize){
        return this.apiResourceService.queryApiResourceByConditionPage(object,pageNum,pageSize);
    }

    @Override
    public List<ApiResourceVo> queryApiResourceByCondition(Object object){
        return this.apiResourceService.queryApiResourceByCondition(object);
    }

    @Override
    public ApiResourceVo add(ApiResourceDto apiResourceDto){
        return this.apiResourceService.add(apiResourceDto);
    }

    @Override
    public boolean edit(ApiResourceDto apiResourceDto){
        return this.apiResourceService.edit(apiResourceDto);
    }

    @Override
    public boolean deleteById(Long id){
       return this.apiResourceService.deleteById(id);
    }

}