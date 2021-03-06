package edu.colorado.thresher.core;

import com.ibm.wala.ipa.callgraph.CGNode;
import com.ibm.wala.ssa.SSACFG;
import com.ibm.wala.ssa.SSAInvokeInstruction;

public class IStackFrame {

  private final SSAInvokeInstruction callInstr; // the instruction that caused
                                                // this frame to be pushed on
                                                // the stack
  private final CGNode cgNode;
  private final SSACFG.BasicBlock block;
  private final int lineNum;

  public IStackFrame(SSAInvokeInstruction callInstr, CGNode cgNode, SSACFG.BasicBlock block, int lineNum) {
    this.callInstr = callInstr;
    this.cgNode = cgNode;
    this.block = block;
    this.lineNum = lineNum;
  }

  public SSAInvokeInstruction getCallInstr() {
    return callInstr;
  }

  public CGNode getCGNode() {
    return cgNode;
  }

  public SSACFG.BasicBlock getBlock() {
    return block;
  }

  public int getLineNum() {
    return lineNum;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof IStackFrame)) return false;
    IStackFrame otherFrame = (IStackFrame) other;
    return this.cgNode.equals(otherFrame.cgNode) &&
        this.block.equals(otherFrame.block) &&
        this.lineNum == otherFrame.lineNum;
  }
  
  @Override
  public String toString() {
    return "CGNode " + this.cgNode;
  }

}
