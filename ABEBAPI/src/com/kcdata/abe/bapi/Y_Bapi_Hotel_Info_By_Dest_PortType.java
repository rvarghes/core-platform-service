package com.kcdata.abe.bapi;
public class Y_Bapi_Hotel_Info_By_Dest_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Hotel_Info_By_Dest.PortType", new java.lang.Object[][][]{{{"Y_BAPI_HOTEL_INFO_BY_DEST", "y_Bapi_Hotel_Info_By_Dest", "Y_BAPI_HOTEL_INFO_BY_DEST"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_HOTEL_INFO_BY_DEST.Input", "com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_HOTEL_INFO_BY_DEST.Output", "com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1289384735437L) ;

    public  Y_Bapi_Hotel_Info_By_Dest_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Output y_Bapi_Hotel_Info_By_Dest(com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Input Y_Bapi_Hotel_Info_By_Dest_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Hotel_Info_By_Dest_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Hotel_Info_By_Dest.PortType", "Y_BAPI_HOTEL_INFO_BY_DEST", new com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
