package .entity.vo;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ApiResourceVo
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("ApiResourceVo" )
public class ApiResourceVo implements Serializable {
    private static final long serialVersionUID = 933978064492087572L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date ctime;
    
    /**
    * 资源名称
    */    
    @ApiModelProperty("资源名称")
    private String name;
    
    /**
    * 资源URL
    */    
    @ApiModelProperty("资源URL")
    private String url;
    
    /**
    * 描述
    */    
    @ApiModelProperty("描述")
    private String description;
    
    /**
    * 资源分类ID
    */    
    @ApiModelProperty("资源分类ID")
    private Long categoryId;
    
}