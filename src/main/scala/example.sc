val nums = List(1,2,7,1,2,1,2,3,3,3);
var a = 0
var b = 0
nums.foreach(x=>{
  b = a & (b ^ x)
  a = b | (a ^ x)
  printf("%d, %d\n", b,a)
})
print(a)

