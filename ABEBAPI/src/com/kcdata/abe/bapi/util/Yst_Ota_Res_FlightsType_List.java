package com.kcdata.abe.bapi.util;
public class Yst_Ota_Res_FlightsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1116919798L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_RES_FLIGHTS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType.class, new com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType(), new java.lang.String[][]{}, 529, 978, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_RES_FLIGHTS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Fligth Items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>529</ifr:internalLength1><ifr:internalLength2>978</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Res_FlightsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean removeYst_Ota_Res_FlightsType(com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType[] toArrayYst_Ota_Res_FlightsType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType[] {});
    }

    public void addYst_Ota_Res_FlightsType(com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType item) {
        baseList().add(item);
    }

    public boolean containsYst_Ota_Res_FlightsType(com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType setYst_Ota_Res_FlightsType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType)baseList().set(index, item);
    }

    public void addYst_Ota_Res_FlightsType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType removeYst_Ota_Res_FlightsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType)baseList().remove(index);
    }

    public void addAllYst_Ota_Res_FlightsType(int index, Yst_Ota_Res_FlightsType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Ota_Res_FlightsType(Yst_Ota_Res_FlightsType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_Ota_Res_FlightsType(Yst_Ota_Res_FlightsType_List item) {
        return baseList().containsAll(item);
    }

    public Yst_Ota_Res_FlightsType_List subListYst_Ota_Res_FlightsType(int fromIndex, int toIndex) {
        return (Yst_Ota_Res_FlightsType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfYst_Ota_Res_FlightsType(com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType getYst_Ota_Res_FlightsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType)baseList().get(index);
    }

    public int indexOfYst_Ota_Res_FlightsType(com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType item) {
        return baseList().indexOf(item);
    }

}
