import simplejson as json

data = {}
data['people']=[]
print(data)

# value
data['people'].append({
    'name':'kim',
    'website':'naver.com',
    'from':'Seoul',
    'grade':[95,77,89,91]
})

data['people'].append({
    'name':'moon',
    'website':'google.com',
    'from':'Seoul',
    'grade':[95,77,89,91]
})

data['people'].append({
    'name':'park',
    'website':'duam.com',
    'from':'Seoul',
    'grade':[95,77,89,91]
})

data['people'].append({
    'name':'Lee',
    'website':'yahoo.com',
    'from':'Seoul',
    'grade':[95,77,89,91]
})

# print(data)

# json 객체로 파일 생성
with open("C:/Users/soldesk/Downloads/JAVA/data/member.json",'w') as outfile:
    json.dump(data,outfile)

# json으로 읽기
with open("C:/Users/soldesk/Downloads/JAVA/data/member.json",'r') as infile:
    r = json.load(infile)
    for p in r['people']:
        print('Name: '+p['name'])
        print('Website: '+p['website'])
        print('From: '+p['from'])
        t = p['grade']
        grade = ''
        for g in t:
            grade = grade+' '+str(g)
        print('Grade: ',grade.lstrip())
        print('')