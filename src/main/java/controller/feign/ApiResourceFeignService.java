package .controller.feign;

import .entity.vo.ApiResourceVo;
import .entity.dto.ApiResourceDto;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * feign服务
 * @author wzn
 * @since 2020-04-13 19:16:38
 */
public interface ApiResourceFeignService {

    @ApiOperation(value = "根据id查询详情")
    @GetMapping("/ApiResource/detals")
    ApiResourceVo queryApiResourceById(Long id);
   
    @ApiOperation(value = "根据条件查询分页")
    @PostMapping("/ApiResource/queryPage")
    List<ApiResourceVo> queryApiResourceByConditionPage(Object object,int pageNum, int pageSize);

    @ApiOperation(value = "根据条件查询")
    @PostMapping("/ApiResource/query")
    List<ApiResourceVo> queryApiResourceByCondition(Object object);

    @ApiOperation(value = "添加")
    @PostMapping("/ApiResource/add")
    ApiResourceVo add(@RequestBody ApiResourceDto apiResourceDto);

    @ApiOperation(value = "修改")
    @PostMapping("/ApiResource/edit")
    boolean edit(@RequestBody ApiResourceDto apiResourceDto);

    @ApiOperation(value = "删除")
    @PostMapping("/ApiResource/del")
    boolean deleteById(Long id);

}