a, b = map(int, input().split())
c = int(input())

m = (b + c) % 60
h = a + ((b + c) // 60)

if h >= 24:
    h = h - 24

print(h, m) 