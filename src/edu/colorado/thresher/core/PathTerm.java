package edu.colorado.thresher.core;

import java.util.List;
import java.util.Set;

import com.ibm.wala.ipa.callgraph.propagation.PointerKey;
import com.ibm.wala.types.FieldReference;
import com.microsoft.z3.AST;
import com.microsoft.z3.Context;

public interface PathTerm extends Comparable {

  public PathTerm deepCopy();

  public String toHumanReadableString();

  public AST toZ3AST(Context ctx, boolean boolVar);

  public Set<PointerVariable> getVars();

  public List<FieldReference> getFields();

  public Set<PointerKey> getPointerKeys();

  public PathTerm substituteExpForFieldRead(SimplePathTerm toSub, PointerVariable subFor, FieldReference fieldName);

  // public PathTerm substituteWithFieldName(PathTerm toSub, PointerVariable
  // subFor, FieldReference fieldName);
  public PathTerm substitute(PathTerm toSub, SimplePathTerm subFor);

  public PathTerm heapSubstitute(SimplePathTerm toSub, SimplePathTerm subFor);

  public int evaluate();

  public boolean substituted();

  public boolean isIntegerConstant();

  public void setSubstituted(boolean substituted);

  public Set<SimplePathTerm> getTerms();

  public boolean symbContains(PathTerm other);

  public boolean isHeapLocation();
    
  public int size();

  // public PointerVariable containsField(FieldReference field);
  @Override
  public int compareTo(Object other);

}
