package com.kcdata.abe.bapi.util;
public class Yzst_Add_Fli_SvcType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1129199107L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YZST_ADD_FLI_SVC", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType.class, new com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType(), new java.lang.String[][]{}, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YZST_T_ADD_FLI_SVC\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Additional Flight Service Information. Returned if Option O</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>tableType</ifr:category><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition><ifr:complexType name=\"YZST_ADD_FLI_SVC\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YZST_ADD_FLI_SVC\" /></ifr:definition></ifr:container></s0:type>") ;

    public  Yzst_Add_Fli_SvcType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType setYzst_Add_Fli_SvcType(int index, com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType item) {
        return (com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType)baseList().set(index, item);
    }

    public void addYzst_Add_Fli_SvcType(int index, com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType item) {
        baseList().add(index, item);
    }

    public void addAllYzst_Add_Fli_SvcType(Yzst_Add_Fli_SvcType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYzst_Add_Fli_SvcType(com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYzst_Add_Fli_SvcType(Yzst_Add_Fli_SvcType_List item) {
        return baseList().containsAll(item);
    }

    public void addYzst_Add_Fli_SvcType(com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType item) {
        baseList().add(item);
    }

    public void addAllYzst_Add_Fli_SvcType(int index, Yzst_Add_Fli_SvcType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYzst_Add_Fli_SvcType(com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType getYzst_Add_Fli_SvcType(int index) {
        return (com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType)baseList().get(index);
    }

    public int lastIndexOfYzst_Add_Fli_SvcType(com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType[] toArrayYzst_Add_Fli_SvcType() {
        return (com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType[])baseList().toArray(new com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType[] {});
    }

    public Yzst_Add_Fli_SvcType_List subListYzst_Add_Fli_SvcType(int fromIndex, int toIndex) {
        return (Yzst_Add_Fli_SvcType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType removeYzst_Add_Fli_SvcType(int index) {
        return (com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType)baseList().remove(index);
    }

    public int indexOfYzst_Add_Fli_SvcType(com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType item) {
        return baseList().indexOf(item);
    }

}
