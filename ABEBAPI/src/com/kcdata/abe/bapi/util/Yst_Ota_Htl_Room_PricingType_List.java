package com.kcdata.abe.bapi.util;
public class Yst_Ota_Htl_Room_PricingType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -416107037L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_HTL_ROOM_PRICING", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType(), new java.lang.String[][]{}, 153, 200, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_HTL_ROOM_PRICING\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel  Pricing</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>153</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Htl_Room_PricingType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType setYst_Ota_Htl_Room_PricingType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType)baseList().set(index, item);
    }

    public void addYst_Ota_Htl_Room_PricingType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Ota_Htl_Room_PricingType(Yst_Ota_Htl_Room_PricingType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Ota_Htl_Room_PricingType(com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Ota_Htl_Room_PricingType(Yst_Ota_Htl_Room_PricingType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Ota_Htl_Room_PricingType(com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType item) {
        baseList().add(item);
    }

    public void addAllYst_Ota_Htl_Room_PricingType(int index, Yst_Ota_Htl_Room_PricingType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Ota_Htl_Room_PricingType(com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType getYst_Ota_Htl_Room_PricingType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType)baseList().get(index);
    }

    public int lastIndexOfYst_Ota_Htl_Room_PricingType(com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType[] toArrayYst_Ota_Htl_Room_PricingType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType[] {});
    }

    public Yst_Ota_Htl_Room_PricingType_List subListYst_Ota_Htl_Room_PricingType(int fromIndex, int toIndex) {
        return (Yst_Ota_Htl_Room_PricingType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType removeYst_Ota_Htl_Room_PricingType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType)baseList().remove(index);
    }

    public int indexOfYst_Ota_Htl_Room_PricingType(com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType item) {
        return baseList().indexOf(item);
    }

}
