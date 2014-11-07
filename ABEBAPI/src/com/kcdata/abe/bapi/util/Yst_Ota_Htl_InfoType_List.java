package com.kcdata.abe.bapi.util;
public class Yst_Ota_Htl_InfoType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 460842831L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_HTL_INFO", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType(), new java.lang.String[][]{}, 240, 474, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_HTL_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>240</ifr:internalLength1><ifr:internalLength2>474</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Htl_InfoType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType setYst_Ota_Htl_InfoType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType)baseList().set(index, item);
    }

    public void addYst_Ota_Htl_InfoType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Ota_Htl_InfoType(Yst_Ota_Htl_InfoType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Ota_Htl_InfoType(com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Ota_Htl_InfoType(Yst_Ota_Htl_InfoType_List item) {
        return baseList().containsAll(item);
    }

    public Yst_Ota_Htl_InfoType_List subListYst_Ota_Htl_InfoType(int fromIndex, int toIndex) {
        return (Yst_Ota_Htl_InfoType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addYst_Ota_Htl_InfoType(com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType item) {
        baseList().add(item);
    }

    public void addAllYst_Ota_Htl_InfoType(int index, Yst_Ota_Htl_InfoType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Ota_Htl_InfoType(com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType removeYst_Ota_Htl_InfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType[] toArrayYst_Ota_Htl_InfoType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType[] {});
    }

    public int lastIndexOfYst_Ota_Htl_InfoType(com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType getYst_Ota_Htl_InfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType)baseList().get(index);
    }

    public int indexOfYst_Ota_Htl_InfoType(com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType item) {
        return baseList().indexOf(item);
    }

}
