table = {
    "number of": "c",
    "amount of": "m",
    "most": "cm",
    "fewest": "c",
    "least": "m",
    "more": "cm",
    "fewer": "c",
    "less": "m",
    "many": "c",
    "much": "m",
    "few": "c",
    "little": "m"
}

# n = int(input())
# p = int(input())
n, p = input().split()
n = int(n)
p = int(p)


for i in range(n):
    noun, typ = input().split()
    table[noun] = typ

output = ""
for i in range(p):
    split = input().split()
    word = split[-1]
    phrase = split[0:-1]

    if table[phrase] in table[word]:
        output += "Correct!\n"
    else:
        output += "Not on my watch!\n"

print(output)
