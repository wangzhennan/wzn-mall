package com.wzn.mall.entity.vo;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * PermissionMenuRelationVo
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("PermissionMenuRelationVo" )
public class PermissionMenuRelationVo implements Serializable {
    private static final long serialVersionUID = -55554167326976463L;
    /**
    * 主键
    */    
    @ApiModelProperty("主键")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long permissionId;
    
        
    @ApiModelProperty("")
    private Long menuId;
    
}