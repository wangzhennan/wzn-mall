package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleResourceRelationVo
 * @author wangzhennan
 * @since 2020-04-14 22:29:25
 */
@Data
@ApiModel("RoleResourceRelationVo" )
public class RoleResourceRelationVo implements Serializable {
    private static final long serialVersionUID = -72834956908544891L;
        
    @ApiModelProperty("")
    private Long id;
    
    /**
    * 角色ID
    */    
    @ApiModelProperty("角色ID")
    private Long roleId;
    
    /**
    * 资源ID
    */    
    @ApiModelProperty("资源ID")
    private Long resourceId;
    
}