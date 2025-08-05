#딕셔너리 자료형(순서X, 중복X, 수정O, 삭제O)

#선언
a = { 'name': 'kim', 'phone': '01077777777', 'birth': '700124' }
b = { 0: 'Hello World!' }
c = { 'arr': [0,1,2,3] }
print('a - ', type(a), a)
print('b - ', type(b), b)
print('c - ', type(c), c)

#출력
print('a - ', a['name'])
print('a - ', a.get('name'))
print('b - ', b[0])
print('b - ', b.get(0))
print('c - ', c.get('arr'))
print('c - ', c['arr'][3])

#dict_keys, dict_values, dict_items : 반복문(iterate) 사용 가능
print('a - ',a.keys())
print('b - ',b.keys())
print('c - ',c.keys())
