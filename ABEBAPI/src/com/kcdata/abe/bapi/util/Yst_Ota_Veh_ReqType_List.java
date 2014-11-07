package com.kcdata.abe.bapi.util;
public class Yst_Ota_Veh_ReqType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 810072970L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_VEH_REQ", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType.class, new com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType(), new java.lang.String[][]{}, 101, 202, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_VEH_REQ\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Vehicle Request</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>101</ifr:internalLength1><ifr:internalLength2>202</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Veh_ReqType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllYst_Ota_Veh_ReqType(int index, Yst_Ota_Veh_ReqType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Ota_Veh_ReqType(Yst_Ota_Veh_ReqType_List item) {
        baseList().addAll(item);
    }

    public int indexOfYst_Ota_Veh_ReqType(com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType item) {
        return baseList().indexOf(item);
    }

    public Yst_Ota_Veh_ReqType_List subListYst_Ota_Veh_ReqType(int fromIndex, int toIndex) {
        return (Yst_Ota_Veh_ReqType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsAllYst_Ota_Veh_ReqType(Yst_Ota_Veh_ReqType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType getYst_Ota_Veh_ReqType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType)baseList().get(index);
    }

    public boolean removeYst_Ota_Veh_ReqType(com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Veh_ReqType(com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType[] toArrayYst_Ota_Veh_ReqType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType[] {});
    }

    public boolean containsYst_Ota_Veh_ReqType(com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType setYst_Ota_Veh_ReqType(int index, com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType)baseList().set(index, item);
    }

    public void addYst_Ota_Veh_ReqType(int index, com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType item) {
        baseList().add(index, item);
    }

    public int lastIndexOfYst_Ota_Veh_ReqType(com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType removeYst_Ota_Veh_ReqType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType)baseList().remove(index);
    }

}
