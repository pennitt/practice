def solution(phone_book):
    answer = True
    phone_book = sorted(phone_book)

    for i, j in zip(phone_book, phone_book[1:]):
        if j.startswith(i):
            answer = False
            break
    return answer


        