export const Microservices: { [key: string]: string } = {
  // give like this :
  // "ms-name" : "http://localhost:[port-no.]/[context-root]"
  // auth: "http://localhost:8100/auth",

  // checklist: "http://localhost:8200/checklist",
  // severity: "http://localhost:8300/severity",

  auth: "http://nitishzx-loadbalancer-1977069289.us-east-1.elb.amazonaws.com/auth",

  checklist:
    "http://nitishzx-loadbalancer-1977069289.us-east-1.elb.amazonaws.com/checklist",
  severity:
    "http://nitishzx-loadbalancer-1977069289.us-east-1.elb.amazonaws.com/severity",
};
