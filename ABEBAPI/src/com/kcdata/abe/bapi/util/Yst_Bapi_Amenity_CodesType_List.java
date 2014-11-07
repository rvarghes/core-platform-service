package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Amenity_CodesType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1805659576L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_AMENITY_CODES", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType.class, new com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType(), new java.lang.String[][]{}, 105, 210, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_AMENITY_CODES\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Amenity Codes and Names</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>105</ifr:internalLength1><ifr:internalLength2>210</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Amenity_CodesType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType setYst_Bapi_Amenity_CodesType(int index, com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType removeYst_Bapi_Amenity_CodesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType)baseList().remove(index);
    }

    public int lastIndexOfYst_Bapi_Amenity_CodesType(com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType item) {
        return baseList().lastIndexOf(item);
    }

    public void addYst_Bapi_Amenity_CodesType(int index, com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType item) {
        baseList().add(index, item);
    }

    public boolean containsAllYst_Bapi_Amenity_CodesType(Yst_Bapi_Amenity_CodesType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllYst_Bapi_Amenity_CodesType(Yst_Bapi_Amenity_CodesType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType[] toArrayYst_Bapi_Amenity_CodesType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType[] {});
    }

    public boolean removeYst_Bapi_Amenity_CodesType(com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType item) {
        return baseList().remove(item);
    }

    public boolean containsYst_Bapi_Amenity_CodesType(com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType getYst_Bapi_Amenity_CodesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType)baseList().get(index);
    }

    public void addYst_Bapi_Amenity_CodesType(com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType item) {
        baseList().add(item);
    }

    public void addAllYst_Bapi_Amenity_CodesType(int index, Yst_Bapi_Amenity_CodesType_List item) {
        baseList().addAll(index, item);
    }

    public Yst_Bapi_Amenity_CodesType_List subListYst_Bapi_Amenity_CodesType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Amenity_CodesType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfYst_Bapi_Amenity_CodesType(com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType item) {
        return baseList().indexOf(item);
    }

}
