package com.wzn.mall.entity.vo;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * PermissionApiResourceRelationVo
 * @author wangzhennan
 * @since 2020-04-15 14:51:35
 */
@Data
@ApiModel("PermissionApiResourceRelationVo" )
public class PermissionApiResourceRelationVo implements Serializable {
    private static final long serialVersionUID = -57066155929551368L;
        
    @ApiModelProperty("")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long permissionId;
    
        
    @ApiModelProperty("")
    private Long apiResourceId;
    
}