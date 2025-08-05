# 변수
foods = {'떡볶이':'순대','짜장면':'단무지','라면':'김치','피자':'콜라','맥주':'반건조오징어','치킨':'와인','삼겹살':'소주'}

# 메인
while(True):
    myfood= input(str(list(foods.keys()))+" 중 오늘의 메뉴는: ")
    if myfood in foods:
        print("<%s>에 맞는 궁합 음식은 <%s>"%(myfood, foods.get(myfood)))
        print("\n")
    elif myfood == '끝':
        break
    else:
        print("<%s> 메뉴는 없는 음식입니다. 다시 주문해주시길 바랍니다"%myfood)
        print("\n")