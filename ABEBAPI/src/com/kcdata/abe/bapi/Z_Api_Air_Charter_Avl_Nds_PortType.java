package com.kcdata.abe.bapi;
public class Z_Api_Air_Charter_Avl_Nds_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Air_Charter_Avl_Nds.PortType", new java.lang.Object[][][]{{{"Z_API_AIR_CHARTER_AVL_NDS", "z_Api_Air_Charter_Avl_Nds", "Z_API_AIR_CHARTER_AVL_NDS"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_AIR_CHARTER_AVL_NDS.Input", "com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_AIR_CHARTER_AVL_NDS.Output", "com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1240775429187L) ;

    public  Z_Api_Air_Charter_Avl_Nds_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Output z_Api_Air_Charter_Avl_Nds(com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Input Z_Api_Air_Charter_Avl_Nds_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Air_Charter_Avl_Nds_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Air_Charter_Avl_Nds.PortType", "Z_API_AIR_CHARTER_AVL_NDS", new com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
