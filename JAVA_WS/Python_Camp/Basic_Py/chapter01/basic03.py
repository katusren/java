print("%d" % 123)
print("%5d" % 123)
print("%05d" % 123)

print("%f" % 123.45)
print("%7.1f" % 123.45)
print("%7.3f" % 123.45)

print("%s" % "Python")
print("%10s" % "Python")

print("{0:d} {1:5d} {2:05d}".format(123, 123, 123))

print("\n줄바꿈\n연습 ")
print("\t탭키\t연습")
print("글자가 \"강조\"되는 효과1")
print("글자가 \'강조\'되는 효과2")
print("\\\\\\ 역슬래쉬 세개 출력")
print(r"\n \t \" \\ 를 그대로 출력")

print(int('0b1101',2))
print(bin(13)) # 10진수인 13을 2진수로 변환
print(bin(0x13)) # 16진수 13을 2진수로 변환
print(bin(0xC5F7))
print(int('10010011',2))
print(int ('0x93',16))
print(int ('73',8))