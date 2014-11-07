package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Contact_PersonType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1518914096L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_CONTACT_PERSON", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType.class, new com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType(), new java.lang.String[][]{}, 361, 722, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_CONTACT_PERSON\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Contact Person Data</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>361</ifr:internalLength1><ifr:internalLength2>722</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Contact_PersonType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType[] toArrayYst_Bapi_Contact_PersonType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType[] {});
    }

    public int indexOfYst_Bapi_Contact_PersonType(com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType item) {
        return baseList().indexOf(item);
    }

    public void addYst_Bapi_Contact_PersonType(int index, com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType removeYst_Bapi_Contact_PersonType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType)baseList().remove(index);
    }

    public void addAllYst_Bapi_Contact_PersonType(Yst_Bapi_Contact_PersonType_List item) {
        baseList().addAll(item);
    }

    public boolean containsYst_Bapi_Contact_PersonType(com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType item) {
        return baseList().contains(item);
    }

    public Yst_Bapi_Contact_PersonType_List subListYst_Bapi_Contact_PersonType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Contact_PersonType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addYst_Bapi_Contact_PersonType(com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType getYst_Bapi_Contact_PersonType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType)baseList().get(index);
    }

    public boolean removeYst_Bapi_Contact_PersonType(com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_Contact_PersonType(Yst_Bapi_Contact_PersonType_List item) {
        return baseList().containsAll(item);
    }

    public int lastIndexOfYst_Bapi_Contact_PersonType(com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType item) {
        return baseList().lastIndexOf(item);
    }

    public void addAllYst_Bapi_Contact_PersonType(int index, Yst_Bapi_Contact_PersonType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType setYst_Bapi_Contact_PersonType(int index, com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType)baseList().set(index, item);
    }

}
