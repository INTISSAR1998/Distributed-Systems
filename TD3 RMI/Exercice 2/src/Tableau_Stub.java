// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

public final class Tableau_Stub
    extends java.rmi.server.RemoteStub
    implements ITableau, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_min_0;
    private static java.lang.reflect.Method $method_moyenne_1;
    private static java.lang.reflect.Method $method_returntab_2;
    
    static {
	try {
	    $method_min_0 = ITableau.class.getMethod("min", new java.lang.Class[] {double[].class});
	    $method_moyenne_1 = ITableau.class.getMethod("moyenne", new java.lang.Class[] {double[].class});
	    $method_returntab_2 = ITableau.class.getMethod("returntab", new java.lang.Class[] {});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public Tableau_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of min(double[])
    public int min(double[] $param_arrayOf_double_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_min_0, new java.lang.Object[] {$param_arrayOf_double_1}, 8722251686908222282L);
	    return ((java.lang.Integer) $result).intValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of moyenne(double[])
    public double moyenne(double[] $param_arrayOf_double_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_moyenne_1, new java.lang.Object[] {$param_arrayOf_double_1}, -3016201936960816130L);
	    return ((java.lang.Double) $result).doubleValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of returntab()
    public double[] returntab()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_returntab_2, null, 1501824585075747095L);
	    return ((double[]) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
