package reporter

class MemberController {
    def memberService

    def createMember() {
        memberService.createAccount()
    }
}
