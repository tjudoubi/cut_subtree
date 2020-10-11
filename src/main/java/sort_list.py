dict = {}
dict_2 = []
dict_3 = []

f = open("J:\\deep learning\\untitled2\\Graduate_experiment-master\\Graduate_experiment-master\\opo_js\\target_2\\d_data")
vector_1 = f.read()
f.close()

# f = open("J:\\deep learning\\untitled2\\Graduate_experiment-master\\Graduate_experiment-master\\opo_js\\target_2\\vector_2")
# vector_2 = f.read()
# f.close()
#
# f = open("J:\\deep learning\\untitled2\\Graduate_experiment-master\\Graduate_experiment-master\\opo_js\\target_2\\coverage")
# coverage = f.read()
# f.close()

v_1 = vector_1.split('\n')
# v_2 = vector_2.split('\n')
# cov = coverage.split('\n')
def list_cmp(elem):
    return elem[1]


for line in v_1:
    if line != "":
        element = line.split(',')
        ll = []
        ss = []
        for i in range(len(element)):
            if i == 0:
                dict[element[0][0:-4]] = str()
                ll.append(element[0][0:-4])
                ss.append(element[0][0:-4])
            elif i!=0 and i!= len(element)-1:
                dict[element[0][0:-4]] += element[i] + ","
            elif i==len(element)-1:
                dict[element[0][0:-4]] += element[i] + ","

            if i == 14 or i >= len(element)-3:
                ll.append(float(element[i]))
            if i == 1 or i >= len(element)-3:
                ss.append(float(element[i]))
        dict_3.append(ss)
        dict_2.append(ll)
dict_2.sort(key = list_cmp,reverse=True)
dict_3.sort(key = list_cmp,reverse=True)
print(dict_2)
# for line in v_2:
#     if line != "":
#         element = line.split(',')
#         for i in range(len(element)):
#             if i!=0 and i!= len(element)-1:
#                 dict[element[0][0:-4]] += element[i] + ","
#             elif i==len(element)-1:
#                 dict[element[0][0:-4]] += element[i] + ","
#
# for line in cov:
#     if line != "":
#         element = line.split(',')
#         for i in range(len(element)):
#             if element[0] not in dict.keys():
#                 continue
#             if i!=0 and i!= len(element)-1:
#                 dict[element[0]] += element[i] + ","
#                 dict_2[element[0]].append(float(element[i]))
#             elif i==len(element)-1:
#                 dict[element[0]] += element[i] + '\n'
#                 dict_2[element[0]].append(float(element[i]))

